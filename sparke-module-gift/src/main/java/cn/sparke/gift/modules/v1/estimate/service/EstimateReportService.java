package cn.sparke.gift.modules.v1.estimate.service;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.gift.modules.v1.estimate.bean.po.TbGiftReportSuggestConfig;
import cn.sparke.gift.modules.v1.estimate.bean.vo.EstimateReport;
import cn.sparke.gift.modules.v1.estimate.bean.vo.Title;
import cn.sparke.gift.modules.v1.estimate.constant.QuestionType;
import cn.sparke.gift.modules.v1.estimate.constant.TeacherEvaluateStatus;
import cn.sparke.gift.modules.v1.estimate.constant.UserIsSubmit;
import cn.sparke.gift.modules.v1.estimate.mapper.EstimateReportMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EstimateReportService {


    @Resource
    private EstimateReportMapper estimateReportMapper;

    /**
     * 获取报告详情
     * @param reportId
     * @return
     */
    public EstimateReport report(String reportId){
        AuthEntity curAuth = ContextUtils.getCurAuth();
        //称号列表
//        List<Title> titles=estimateReportMapper.queryTitles(curAuth.getSectionCode());
        //查询报告详情
        EstimateReport report=estimateReportMapper.queryReport(curAuth.getSectionCode(),reportId);
//        report.setTitles(titles);
        //查询建议
//        List<TbGiftReportSuggestConfig> suggestList=estimateReportMapper.querySuggest(curAuth.getSectionCode());
//        setSuggest(suggestList,report);

        //如果用户提交了翻译并且是自己批改
        if(UserIsSubmit.USER_SUBMIT==report.getTranslateSubmit()&& TeacherEvaluateStatus.NO_EVALUATE==report.getTeacherEvaluateStatus()){
            //查询用户自评列表
            report.setTranslateUserEstimate(estimateReportMapper.queryUserEstimate(report.getTranslateAnswerId()));
        }
        //如果用户提交了写作并且是自己批改
        if(UserIsSubmit.USER_SUBMIT==report.getWriteSubmit()&&TeacherEvaluateStatus.NO_EVALUATE==report.getTeacherEvaluateStatus()){
            //查询用户自评列表
            report.setWriteUserEstimate(estimateReportMapper.queryUserEstimate(report.getWriteAnswerId()));
        }
        return report;
    }

//    private void setSuggest( List<TbGiftReportSuggestConfig> suggestList,EstimateReport report){
//        if(suggestList!=null&&suggestList.size()>0){
//            for(TbGiftReportSuggestConfig suggestConfig:suggestList){
//                if(suggestConfig.getQuestionType()== QuestionType.LISTEN.getValue()&&suggestConfig.getStartScore()<=report.getScoreListen()&&report.getScoreListen()<=suggestConfig.getEndScore()){
//                    report.setListenSuggestion(suggestConfig.getContent());
//                }else if(suggestConfig.getQuestionType()==QuestionType.READ.getValue()&&suggestConfig.getStartScore()<=report.getScoreRead()&&report.getScoreRead()<=suggestConfig.getEndScore()){
//                    report.setReadSuggestion(suggestConfig.getContent());
//                }else if(suggestConfig.getQuestionType()==QuestionType.TRANSLATION.getValue()&&suggestConfig.getStartScore()<=report.getScoreTranslate()&&report.getScoreTranslate()<=suggestConfig.getEndScore()){
//                    report.setTranslateSuggestion(suggestConfig.getContent());
//                }else if(suggestConfig.getQuestionType()==QuestionType.WRITING.getValue()&&suggestConfig.getStartScore()<=report.getScoreWrite()&&report.getScoreWrite()<=suggestConfig.getEndScore()){
//                    report.setWriteSuggestion(suggestConfig.getContent());
//                }
//            }
//        }
//    }
}
