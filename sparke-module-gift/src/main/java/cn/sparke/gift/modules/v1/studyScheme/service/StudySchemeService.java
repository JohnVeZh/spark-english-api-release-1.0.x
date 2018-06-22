package cn.sparke.gift.modules.v1.studyScheme.service;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.core.common.utils.Utils;
import cn.sparke.gift.modules.v1.studyScheme.bean.*;
import cn.sparke.gift.modules.v1.studyScheme.constants.GiftEvaluateStatusConstants;
import cn.sparke.gift.modules.v1.studyScheme.constants.GiftPeriodConstants;
import cn.sparke.gift.modules.v1.studyScheme.constants.ReportIsSkipConstants;
import cn.sparke.gift.modules.v1.studyScheme.mapper.StudySchemeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yangye on 2017-08-21.
 */
@Service
public class StudySchemeService {
    @Autowired
    private StudySchemeMapper studySchemeMapper;

    /**
     * 用户学习方案
     *
     * @param userId
     * @param sectionCode
     * @return
     */
    public ResponseEntity details(String userId, int sectionCode) {
        // 只有学前才有学习方案
        GiftReportBean report = studySchemeMapper.getReport(userId, sectionCode, GiftPeriodConstants.STUDY_BEFORE);
        if (report == null) {
            return new ResponseErrorEntity(StatusCode.GIFT_REPORT_NOT_GENERATE, HttpStatus.BAD_REQUEST);
        }
        // 是否教师评分中
        if (report.getTeacherEvaluateStatus() == GiftEvaluateStatusConstants.EVALUATE_ING) {
            return new ResponseErrorEntity(StatusCode.GIFT_TEACHER_EVALUATE_ING, HttpStatus.BAD_REQUEST);
        }
        // 获取学习方案信息
        GiftPlanConfigBean planConfig = studySchemeMapper.getPlanConfig(sectionCode, report.getTotalScore());
        if (planConfig == null) { // 暂未配置推荐学习方案规则
            return new ResponseErrorEntity(StatusCode.GIFT_STUDY_SCHEME_RULE_NOT_EXIST, HttpStatus.BAD_REQUEST);
        }
        planConfig.setCourseList(studySchemeMapper.getRecommendCourseList(planConfig.getId()));
        return ResponseEntity.ok(planConfig);
    }

    /**
     * 学习方案列表
     *
     * @return
     */
    public List<LearningProgram> list() {
        AuthEntity curAuth = ContextUtils.getCurAuth();
        return studySchemeMapper.queryPlanListBySectionCode(curAuth.getSectionCode());
    }

    /**
     * 学习方案详情
     *
     * @return
     */
    public PlanInfo info(String planId) {
        return new PlanInfo(studySchemeMapper.queryPlanInfoWithRecommendCourse(planId));
    }

    /**
     * 提交用户方案
     * @param schemeId
     */
    public void submitScheme(String schemeId){
        AuthEntity curAuth = ContextUtils.getCurAuth();
        studySchemeMapper.insertScheme(new TBGiftReport(curAuth.getUserId(),curAuth.getSectionCode(), ReportIsSkipConstants.SKIP),schemeId);
    }
}
