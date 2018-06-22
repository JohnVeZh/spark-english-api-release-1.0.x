package cn.sparke.goods.modules.v1.networkCourse.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.bean.ResultError;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.goods.modules.v1.networkCourse.bean.*;
import cn.sparke.goods.modules.v1.networkCourse.service.ProductNetworkCourseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangye on 2017/7/12.
 */
@RestController
@RequestMapping("/${version}/network_courses")
public class ProductNetworkCourseController {
    @Autowired
    private ProductNetworkCourseService courseService;

    /**
     * 获取网课首页列表
     *
     * @param start
     * @param rows
     * @param courseType
     * @param searchType
     * @param isFree
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity findList(@RequestParam("start") Integer start,
                                   @RequestParam(value = "rows", required = false) Integer rows,
                                   @RequestParam(value = "userId", required = false) String userId,
                                   @RequestParam(value = "sectionCode", required = false) Integer sectionCode,
                                   @RequestParam(value = "courseType", required = false) String courseType,
                                   @RequestParam(value = "searchType", required = false) String searchType,
                                   @RequestParam(value = "isFree", required = false) Integer isFree) {
        if (rows != null && StringUtils.isNotBlank(searchType)) {
            return ResponseEntity.ok(courseService.findWebList(start, rows, searchType, isFree));
        } else if (StringUtils.isNotBlank(courseType)) {
            return ResponseEntity.ok(courseService.findList(start, userId, sectionCode, courseType));
        }
        return new ResponseErrorEntity(new ResultError(StatusCode.VALIDATION_FAILED), HttpStatus.BAD_REQUEST);
    }

    /**
     * 根据网课id、用户id，查询网课详情
     *
     * @param courseId 网课id
     * @return
     */
    @GetMapping("/{courseId}")
    public ResponseEntity getById(@PathVariable("courseId") String courseId) {
        ProductNetworkCourseBean courseBean = courseService.getById(courseId);
        return ResponseEntity.ok(courseBean);
    }

    /**
     * 根据课程id，查询课程目录列表
     *
     * @param courseId 课程id
     * @return
     */
    @GetMapping("/catalogs/{courseId}")
    public ResponseEntity getCatalogsList(@PathVariable("courseId") String courseId) {
        return ResponseEntity.ok(courseService.getCatalogsList(courseId));
    }

    /**
     * 根据搜索id、搜索类型，查询视频列表
     *
     * @param searchId   搜索id（网课id / 目录id）
     * @param searchType 搜索类型 1.网课id; 2: 目录id
     * @return
     */
    @GetMapping("/videos")
    public ResponseEntity getVideosList(@RequestParam(value = "searchId") String searchId, @RequestParam(value = "searchType") String searchType) {
        return ResponseEntity.ok(courseService.getVideosList(searchId, searchType));
    }

    /**
     * 根据课程id查询教师列表
     *
     * @param courseId 课程id
     * @return
     */
    @GetMapping("/teachers/list/{courseId}")
    public ResponseEntity getTeachersList(@PathVariable(value = "courseId") String courseId) {
        return ResponseEntity.ok(courseService.getTeachersList(courseId));
    }

    @GetMapping("/teachers/details/{teacherId}")
    public ResponseEntity getTeacherDetails(@PathVariable(value = "teacherId") String teacherId) {
        return ResponseEntity.ok(courseService.getTeacherDetails(teacherId));
    }

    @GetMapping("/teachers/courses")
    public ResponseEntity getTeacherCourses(@RequestParam("start") Integer start, @RequestParam(value = "rows") Integer rows, @RequestParam("teacherId") String teacherId) {
        return ResponseEntity.ok(courseService.getTeacherCourses(start, rows, teacherId));
    }

    /**
     * 预约/领取网课
     *
     * @param uncBean
     * @return
     */
    @PostMapping("/obtain")
    @LoginAnnot
    public ResponseEntity obtainNetworkCourse(@Validated @RequestBody UserNetworkCourseBean uncBean) {
        uncBean.setUserId(ContextUtils.getCurAuth().getUserId());
        courseService.obtainNetworkCourse(uncBean);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 新增/更新视频播放记录
     * @param playlogBean
     * @return
     */
    @PostMapping("/videos/playlogs")
    public ResponseEntity createOrUpdateVideoPlaylog(@Validated @RequestBody ProductNetworkCoursePlaylogBean playlogBean) {
        courseService.createOrUpdateVideoPlaylog(playlogBean);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 录播-视频验证回调
     *
     * @param verificationcode 验证码，格式：{userId}_{terminal}_{courseId}，如：8a987df75a6a023c015a6b5e59d40acd_1_129f886c2f204e258b3329cede69ba77
     * @param vid              cc视频id
     * @return
     */
    @PostMapping("/videos/auth")
    public ResponseEntity videoAuth(@RequestParam("verificationcode") String verificationcode, @RequestParam("vid") String vid) {
        Map<String, Object> resultMap = new HashMap<>();
        if (StringUtils.isNotBlank(verificationcode) && StringUtils.isNotBlank(vid) && courseService.videoAuthStatus(verificationcode, vid) > 0) {
            resultMap.put("response", new CCVideoResponseBean(1, "课程视频验证成功！"));
        } else {
            resultMap.put("response", new CCVideoResponseBean());
        }
        return ResponseEntity.ok(resultMap);
    }

    /**
     * 直播-视频验证回调
     * @param roomid        直播间id
     * @param viewername    用户id
     * @param viewertoken   用户token，格式：{userId}_{terminal}_{courseId}，如：8a987df75a6a023c015a6b5e59d40acd_1_129f886c2f204e258b3329cede69ba77
     * @return
     */
    @PostMapping("/live/auth")
    public ResponseEntity liveAuth(@RequestParam("roomid") String roomid, @RequestParam("viewername") String viewername, @RequestParam("viewertoken") String viewertoken) {
        if (StringUtils.isNotBlank(roomid) && StringUtils.isNotBlank(viewername) && StringUtils.isNotBlank(viewertoken)) {
            return ResponseEntity.ok(courseService.liveAuthStatus(viewertoken, roomid));
        }
        return ResponseEntity.ok(new CCLiveResponseBean("err", "请购买此课程！"));
    }
}