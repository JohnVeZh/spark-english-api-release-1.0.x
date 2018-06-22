package cn.sparke.gift.modules.v1.recommendCourse.service;

import cn.sparke.gift.modules.v1.recommendCourse.mapper.RecommendCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by yangye on 2017/7/12.
 */
@Service
public class RecommendCourseService {
    @Autowired
    private RecommendCourseMapper courseMapper;

    public ResponseEntity detailsBySectionCode(int sectionCode) {
        return ResponseEntity.ok(courseMapper.detailsBySectionCode(sectionCode));
    }



}
