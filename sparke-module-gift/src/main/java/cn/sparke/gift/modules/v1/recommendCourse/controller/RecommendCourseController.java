package cn.sparke.gift.modules.v1.recommendCourse.controller;

import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.gift.modules.v1.recommendCourse.service.RecommendCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangye on 2017/7/12.
 */
@RestController
@RequestMapping("/${version}/recommend_course")
public class RecommendCourseController {

    @Autowired
    private RecommendCourseService courseService;

    /**
     * 根据sectionCode，查询课程推荐详情
     */
    @GetMapping("/details")
    public ResponseEntity detailsBySectionCode() {
        return courseService.detailsBySectionCode(ContextUtils.getCurAuth().getSectionCode());
    }

}