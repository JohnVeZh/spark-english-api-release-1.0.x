package cn.sparke.user.modules.v1.center.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.core.common.mybatis.utils.PagerUtils;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.user.modules.v1.center.bean.*;
import cn.sparke.user.modules.v1.center.constants.CenterConstants;
import cn.sparke.user.modules.v1.center.constants.CourseTypeConstants;
import cn.sparke.user.modules.v1.center.mapper.CenterMapper;
import com.github.pagehelper.Page;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhangbowen on 2017/7/12.
 */
@RestController
@RequestMapping("/${version}/center")
public class CenterController {
    @Autowired
    private CenterMapper centerMapper;

    /**
     * 我的评论列表
     *
     * @return
     */
    @GetMapping("/comments")
    @LoginAnnot
    public ResponseEntity commentList(@RequestParam Integer start) {
        String userId = ContextUtils.getCurAuth().getUserId();
        MyCommentBean commentBean = new MyCommentBean();
        commentBean.setUserId(userId);
        commentBean.setStart(start);
        return ResponseEntity.ok(PagerUtils.getPager(centerMapper.myCommentList(commentBean)));
    }

    /**
     * 我的订单列表
     *
     * @return
     */
    @GetMapping("/orders/{type}")
    @LoginAnnot
    public ResponseEntity orders(@PathVariable Integer type, @RequestParam Integer start, @RequestParam(required = false) Integer orderStatus) {
        String userId = ContextUtils.getCurAuth().getUserId();
        MyOrderBean myOrderBean = new MyOrderBean();
        myOrderBean.setUserId(userId);
        myOrderBean.setOrderStatus(orderStatus);
        switch (type) {
            case CenterConstants.ORDER.TYPE_BOOK:
                myOrderBean.setStart(start);
                return ResponseEntity.ok(PagerUtils.getPager(centerMapper.orderBookList(myOrderBean)));
            case CenterConstants.ORDER.TYPE_NETWORK:
                //当为网课的时候，判断请求状态是否为退款状态
                if (orderStatus != null && orderStatus == CenterConstants.ORDER.STATUS_REFUND) {
                    List<MyOrderBean<OrderDetailNetworkBean>> list = centerMapper.orderNetworkListByRefund(myOrderBean, new RowBounds(start, 1));
                    PagerBean<MyOrderBean<OrderDetailNetworkBean>> pagerBean = new PagerBean<>();
                    if (list.size() == 0) {
                        pagerBean.setTotal(0);
                    } else {
                        pagerBean.setTotal(centerMapper.orderNetworkListByRefundTotal(myOrderBean));
                    }
                    pagerBean.setData(list);
                    return ResponseEntity.ok(pagerBean);
                } else {
                    myOrderBean.setStart(start);
                    return ResponseEntity.ok(PagerUtils.getPager(centerMapper.orderNetworkList(myOrderBean)));
                }
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 我的网课列表
     *
     * @return
     */
    @GetMapping("/my_courses_list")
    @LoginAnnot
    public ResponseEntity network_course(@RequestParam Integer start, Integer courseType) {
        MyNetworkCourseBean courseBean = new MyNetworkCourseBean();
        courseBean.setCourseType(courseType);
        courseBean.setStart(start);
        courseBean.setUserId(ContextUtils.getCurAuth().getUserId());

        Page<MyNetworkCourseBean> courseList = centerMapper.myNetworkList(courseBean);
        return ResponseEntity.ok(PagerUtils.getPager(courseList));
    }

    /**
     * 我的网课列表
     *
     * @return
     */
    @GetMapping("/reserved_courses_list")
    @LoginAnnot
    public ResponseEntity reservedCoursesList(@RequestParam Integer start) {
        MyNetworkCourseBean courseBean = new MyNetworkCourseBean();
        courseBean.setStart(start);
        courseBean.setUserId(ContextUtils.getCurAuth().getUserId());

        Page<MyNetworkCourseBean> courses = centerMapper.myReservedCoursesList(courseBean);
        return ResponseEntity.ok(PagerUtils.getPager(courses));
    }

    /**
     * 我的网课详情-视频列表
     *
     * @return
     */
    @GetMapping("/course_videos_list")
    @LoginAnnot
    public ResponseEntity reservedCoursesList(@RequestParam String courseId, @RequestParam(value = "isHide", required = false) Integer isHide) {
        return ResponseEntity.ok(centerMapper.getMyNetworkCourseVideosList(courseId, ContextUtils.getCurAuth().getUserId(), isHide));
    }

    /**
     * 我的优惠券列表
     *
     * @return
     */
    @GetMapping("/coupons")
    @LoginAnnot
    public ResponseEntity coupons(@RequestParam Integer start, @RequestParam Integer status) {
        String userId = ContextUtils.getCurAuth().getUserId();
        MyCouponBean myCouponBean = new MyCouponBean();
        myCouponBean.setUserId(userId);
        myCouponBean.setStatus(status);
        myCouponBean.setStart(start);
        return ResponseEntity.ok(PagerUtils.getPager(centerMapper.myCouponList(myCouponBean)));
    }

    /**
     * 个人详情
     *
     * @return
     */
    @GetMapping("/info")
    @LoginAnnot
    public ResponseEntity info() {
        String userId = ContextUtils.getCurAuth().getUserId();
        return ResponseEntity.ok(centerMapper.userInfo(userId));
    }

    /**
     * 资料修改
     *
     * @return
     */
    @PutMapping("/info")
    @LoginAnnot
    public ResponseEntity updateInfo(@RequestBody UserInfo userInfo) {
        String userId = ContextUtils.getCurAuth().getUserId();
        userInfo.setId(userId);
        userInfo.preUpdate();
        centerMapper.updateUser(userInfo);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 热搜列表
     *
     * @return
     */
    @GetMapping("/hot_search_list")
    public ResponseEntity hotSearchList(@RequestParam(value = "searchType", required = false) Integer searchType) {
        return ResponseEntity.ok(centerMapper.getHotSearchList(searchType));
    }
}
