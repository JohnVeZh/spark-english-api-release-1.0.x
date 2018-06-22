package cn.sparke.gift.modules.v1.studyScheme.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.gift.modules.v1.studyScheme.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yangye on 2017/7/12.
 */
public interface StudySchemeMapper extends BaseMapper<GiftPlanConfigBean> {

    /*
     * 获取用户学习报告
     */
    GiftReportBean getReport(@Param("userId") String userId, @Param("sectionCode") int sectionCode, @Param("period") int period);

    /*
     * 获取用户学习方案
     */
    GiftPlanConfigBean getPlanConfig(@Param("sectionCode") int sectionCode, @Param("totalScore") int totalScore);

    /*
     * 获取推荐课程列表
     */
    List<RecommendCourseBean> getRecommendCourseList(@Param("schemeId") String schemeId);


    /**
     * 按学段查询该学段的分值区间
     * @param sectionCode 学段
     * @return
     */
    List<LearningProgram> queryPlanListBySectionCode(@Param("sectionCode") int sectionCode);

    /**
     * 查询推荐的课程列表
     * @param planId 方案id
     * @return
     */
    List<CourseInfo> queryPlanInfoWithRecommendCourse(@Param("planId") String planId);

    /**
     * 插入用户的方案
     */
    void insertScheme(@Param("report") TBGiftReport report, @Param("schemeId") String schemeId);

}