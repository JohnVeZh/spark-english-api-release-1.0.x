package cn.sparke.goods.modules.v1.networkCourse.service;

import cn.sparke.core.common.constants.PageConstants;
import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.goods.modules.v1.networkCourse.bean.*;
import cn.sparke.goods.modules.v1.networkCourse.constants.CourseTypeConstants;
import cn.sparke.goods.modules.v1.networkCourse.constants.OrderTypeConstants;
import cn.sparke.goods.modules.v1.networkCourse.constants.TerminalConstants;
import cn.sparke.goods.modules.v1.networkCourse.mapper.ProductNetworkCourseMapper;
import cn.sparke.goods.modules.v1.utils.CommUtil;
import cn.sparke.goods.modules.v1.utils.MyPageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangye on 2017/7/12.
 */
@Service
public class ProductNetworkCourseService {
    @Autowired
    private ProductNetworkCourseMapper courseMapper;

    public PagerBean<ProductNetworkCourseBean> findList(Integer start, String userId, Integer sectionCode, String courseType) {
        PageHelper.offsetPage(start, PageConstants.PAGE_NUM);
        return MyPageUtil.getPagerBean(new PageInfo<>(courseMapper.findList(userId, courseType, sectionCode)));
    }

    public PagerBean<ProductNetworkCourseBean> findWebList(Integer start, Integer rows, String searchType, Integer isFree) {
        PageHelper.offsetPage(start, rows);
        return MyPageUtil.getPagerBean(new PageInfo<>(courseMapper.findWebList(ContextUtils.getCurAuth().getUserId(), searchType, isFree, ContextUtils.getCurAuth().getSectionCode())));
    }

    public ProductNetworkCourseBean getById(String courseId) {
        return courseMapper.getById(courseId, ContextUtils.getCurAuth().getUserId());
    }

    public PagerBean<ProductNetworkCourseCatalogBean> getCatalogsList(String courseId) {
        // PageHelper.offsetPage(start,10);
        List<ProductNetworkCourseCatalogBean > catalogsList = courseMapper.getCatalogsList(courseId);
        return MyPageUtil.getPagerBean(new PageInfo<>(catalogsList));
    }

    public PagerBean<ProductNetworkCourseVideoBean> getVideosList(String searchId, String searchType) {
        List<ProductNetworkCourseVideoBean> videosList = courseMapper.getVideosList(searchId, searchType, ContextUtils.getCurAuth().getUserId());
        Integer gainStatus = OrderTypeConstants.ORDER_TYPE.PAY; // 订单类型，是否已购买
        ProductNetworkCourseBean courseBean = courseMapper.getProductInfo(searchId, searchType);
        if (courseBean != null && (courseBean.getIsFamousTeacher() == 1 || courseBean.getIsFree() == 1)) { // 名师视频/免费课程，则购买状态为1
            gainStatus = OrderTypeConstants.ORDER_TYPE.PAY;
        } else if(courseBean != null && courseBean.getIsFamousTeacher() == 0) { // 非名师视频
            courseBean = courseMapper.orderState(courseBean.getProductId(), ContextUtils.getCurAuth().getUserId());
        }
        gainStatus = courseBean == null ? OrderTypeConstants.ORDER_TYPE.NO_PAY : gainStatus;
        if (gainStatus == 0) { // 用户未购买
            for(int i = 0; i< videosList.size();i++) {
                if (ContextUtils.getCurAuth().getTerminal() != CourseTypeConstants.TERMINAL.PC || i != 0) { // 只有PC端视频列表中第一个视频才显示CC视频信息
                    videosList.get(i).setVideoCcId(null);
                    videosList.get(i).setLiveCcId(null);
                    videosList.get(i).setLiveRoomId(null);
                }
            }
        }
        return MyPageUtil.getPagerBean(new PageInfo<>(videosList));
    }

    public PagerBean<ProductNetworkCourseTeacherBean> getTeachersList(String courseId) {
        List<ProductNetworkCourseTeacherBean > teachersList = courseMapper.getTeachersList(courseId);
        return MyPageUtil.getPagerBean(new PageInfo<>(teachersList));
    }

    public ProductNetworkCourseTeacherBean getTeacherDetails(String teacherId) {
        return courseMapper.getTeacherDetails(teacherId);
    }

    public PagerBean<ProductNetworkCourseBean> getTeacherCourses(Integer start, Integer rows, String teacherId) {
        PageHelper.offsetPage(start, rows);
        return MyPageUtil.getPagerBean(new PageInfo<>(courseMapper.getTeacherCourses(teacherId)));
    }

    public int obtainNetworkCourse(UserNetworkCourseBean uncBean) {
        uncBean.setId(CommUtil.getUuid());
        courseMapper.incrementNetworkCourseObtainCount(uncBean); // 网课领取数+1
        return courseMapper.obtainNetworkCourse(uncBean);
    }

    public int createOrUpdateVideoPlaylog(ProductNetworkCoursePlaylogBean playlogBean) {
        playlogBean.setId(CommUtil.getUuid());
        return courseMapper.createOrUpdateVideoPlaylog(playlogBean);
    }

    /**
     * 录播验证接口
     * 1、需要处理cc视频id为预告片时的id的情况（1、网课预告片ccid（已处理）; // TODO 2、视频预告片ccid（暂不验证））;
     * 2、根据不同终端，判断如果ccVideoId为第一个视频时，是否可以免费试看；
     * 3、在PC端: 公开课/名师视频，不需要领取可以直接观看，非PC端：名师视频可以直接观看；
     * 4、根据userId,courseId,ccVideoId，判断用户是否存在网课关系记录；
     * @param authStr       验证串，格式：{userId}_{terminal}_{courseId}
     * @param ccVideoId     CC视频Id
     * @return
     */
    public int videoAuthStatus(String authStr, String ccVideoId) {
        Map<String, Object> authMap = this.getAuthParamsMap(authStr); // userId,terminal,courseId
        Integer terminal = authMap.get("terminal") == null ? 0 : Integer.parseInt(authMap.get("terminal").toString());
        String courseId = authMap.get("courseId") == null ? "" : authMap.get("courseId").toString();
        String userId = authMap.get("userId") == null ? "" : authMap.get("userId").toString();
        // 1、判断ccid是否是网课预告片ccid
        if (courseMapper.getPreviewVideoCount(courseId, ccVideoId) > 0) {
            return 1;
        }
        // 2、终端类型如果为PC端时，第一个videoCcId / liveCcId的视频可以免费试看
        if (TerminalConstants.PC.equals(terminal) && (ccVideoId.equals(courseMapper.getCourseFirstVideoCcId(courseId)) || ccVideoId.equals(courseMapper.getCourseFirstLiveCcId(courseId)))) {
            return 1;
        }
        // 3、在PC端: 公开课/名师视频，不需要领取可以直接观看，非PC端：名师视频可以直接观看；
        if ((TerminalConstants.PC.equals(terminal) && courseMapper.getCourseIsFreeOrFamousTeacher(courseId) == 1) || (!TerminalConstants.PC.equals(terminal)) && courseMapper.getCourseFamousTeacher(courseId) == 1) {
            return 1;
        } else { // 4、判断是否存在用户网课关系记录
            return courseMapper.videoAuthStatus(userId, courseId, ccVideoId);
        }
    }

    /**
     * 1、判断是否公开课/名师视频，公开课在PC端卜需要领取可以直接观看；
     * 2、//TODO 根据不同终端，验证直播课视频是否第一个是否可以试看（暂不验证）
     * 3、验证 网课中直播间id/视频中直播间id
     * @param authStr        验证串，格式：{userId}_{terminal}_{courseId}
     * @param liveRoomId     直播间Id
     * @return
     */
    public CCLiveResponseBean liveAuthStatus(String authStr, String liveRoomId) {
        CCLiveResponseBean response;
        Map<String, Object> authMap = this.getAuthParamsMap(authStr);
        String userId = authMap.get("userId") == null ? "" : authMap.get("userId").toString();
        String courseId = authMap.get("courseId") == null ? "" : authMap.get("courseId").toString();
        Integer terminal = authMap.get("terminal") == null ? 0 : Integer.parseInt(authMap.get("terminal").toString());
        // 1、判断是否公开课/名师视频，公开课在PC端不需要领取可以直接观看（名师视频不存在直播，所以不需处理直播）
        if (TerminalConstants.PC.equals(terminal) && courseMapper.getCourseIsFreeOrFamousTeacher(courseId) == 1) {
            response = new CCLiveResponseBean("ok", "登录成功");
            response.setUser(courseMapper.getCcLiveUserInfo(userId));
        } else { // 3、验证是否 网课中直播间id/视频中直播间id
            CCLiveUserBean user = courseMapper.liveAuthCourseStatus(userId, courseId, liveRoomId);
            if (user == null) { // 视频中直播间id
                user = courseMapper.liveAuthVideoStatus(userId, courseId, liveRoomId);
            }
            if (user != null) {
                response = new CCLiveResponseBean("ok", "登录成功");
                response.setUser(user);
            } else {
                response = new CCLiveResponseBean("err", "请购买此课程！");
            }
        }
        return response;
    }

    /**
     * 获取验证参数字典
     * @param authStr   验证字符串
     * @return
     */
    public Map<String, Object> getAuthParamsMap(String authStr) {
        Map<String, Object> authMap = new HashMap<>();
        if (StringUtils.isNotBlank(authStr) && authStr.contains("_")) {
            String[] authArray = authStr.split("_");
            authMap.put("userId", authArray.length > 0 ? authArray[0] : null);
            authMap.put("terminal", authArray.length > 1 ? authArray[1] : null);
            authMap.put("courseId", authArray.length > 2 ? authArray[2] : null);
        }
        return authMap;
    }

}
