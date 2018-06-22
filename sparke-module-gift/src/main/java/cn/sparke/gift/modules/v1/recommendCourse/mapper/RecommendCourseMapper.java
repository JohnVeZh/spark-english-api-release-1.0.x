package cn.sparke.gift.modules.v1.recommendCourse.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.gift.modules.v1.recommendCourse.bean.RecommendCourseBean;
import org.apache.ibatis.annotations.Param;

/**
 * Created by yangye on 2017/7/12.
 */
public interface RecommendCourseMapper extends BaseMapper<RecommendCourseBean> {

    RecommendCourseBean detailsBySectionCode(@Param("sectionCode") int sectionCode);

}