package cn.sparke.gift.modules.v1.estimate.service;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.core.common.utils.Utils;
import cn.sparke.gift.modules.v1.estimate.bean.po.TbGiftPaperAnswer;
import cn.sparke.gift.modules.v1.estimate.bean.po.TbGiftPeriodPaper;
import cn.sparke.gift.modules.v1.estimate.bean.po.TbGiftReport;
import cn.sparke.gift.modules.v1.estimate.bean.po.TbGiftSubjectiveRuleDetail;
import cn.sparke.gift.modules.v1.estimate.bean.po.TbGiftSubjectiveSubmitRecord;
import cn.sparke.gift.modules.v1.estimate.bean.po.TbGiftUserAnswer;
import cn.sparke.gift.modules.v1.estimate.bean.po.TbGiftUserAnswerSubjective;
import cn.sparke.gift.modules.v1.estimate.bean.vo.AnswerInfoVo;
import cn.sparke.gift.modules.v1.estimate.bean.vo.ObjectiveAnswerVo;
import cn.sparke.gift.modules.v1.estimate.bean.vo.SubjectiveAnswerVoDetailIdVo;
import cn.sparke.gift.modules.v1.estimate.bean.vo.SubmitAnswerVo;
import cn.sparke.gift.modules.v1.estimate.constant.PeriodType;
import cn.sparke.gift.modules.v1.estimate.constant.QuestionType;
import cn.sparke.gift.modules.v1.estimate.constant.TeacherEvaluateStatus;
import cn.sparke.gift.modules.v1.estimate.mapper.TbGiftPaperAnswerMapper;
import cn.sparke.gift.modules.v1.estimate.mapper.TbGiftPeriodPaperMapper;
import cn.sparke.gift.modules.v1.estimate.mapper.TbGiftReportMapper;
import cn.sparke.gift.modules.v1.estimate.mapper.TbGiftSubjectiveRuleDetailMapper;
import cn.sparke.gift.modules.v1.estimate.mapper.TbGiftSubjectiveSubmitRecordMapper;
import cn.sparke.gift.modules.v1.estimate.mapper.TbGiftUserAnswerMapper;
import cn.sparke.gift.modules.v1.estimate.mapper.TbGiftUserAnswerSubjectiveMapper;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/8/21 10:38
 */
@Service
public class UserAnswerService {
    @Resource
    private TbGiftUserAnswerMapper userAnswerMapper;
    @Resource
    private TbGiftUserAnswerSubjectiveMapper userAnswerSubjectiveMapper;
    @Resource
    private TbGiftReportMapper giftReportMapper;
    @Resource
    private TbGiftPeriodPaperMapper giftPeriodPaperMapper;
    @Resource
    private TbGiftPaperAnswerMapper giftPaperAnswerMapper;
    @Resource
    private TbGiftSubjectiveRuleDetailMapper giftSubjectiveRuleDetailMapper;
    @Resource
    private TbGiftSubjectiveSubmitRecordMapper tbGiftSubjectiveSubmitRecordMapper;


    @Transactional
    public ResponseEntity submit(String paperId, SubmitAnswerVo submitAnswerVo, boolean checkNeedSystemCorrect) {
        AuthEntity authEntity = ContextUtils.getCurAuth();
        TbGiftPeriodPaper giftPeriodPaper = giftPeriodPaperMapper.getById(paperId);
        if (giftPeriodPaper == null) {
            return new ResponseErrorEntity(StatusCode.GIFT_ESTIMATE_PAPERID_ERROR, HttpStatus.BAD_REQUEST);
        }
        List<TbGiftPaperAnswer> giftPaperAnswerList = giftPaperAnswerMapper.findListByPaperId(paperId);
        if (giftPaperAnswerList == null || giftPaperAnswerList.size() < 1) {
            return new ResponseErrorEntity(StatusCode.GIFT_ESTIMATE_PAPERID_ERROR, HttpStatus.BAD_REQUEST);
        }

        TbGiftReport dbGiftReport = giftReportMapper.getByUserIdAndSectionCodeAndPeriod(authEntity.getUserId(), giftPeriodPaper.getSectionCode(), giftPeriodPaper.getPeriod());
        if (dbGiftReport != null) {
            return new ResponseErrorEntity(StatusCode.GIFT_ESTIMATE_PAPER_AREALY_REPORT, HttpStatus.BAD_REQUEST);
        }

        //正确答案信息
        Map<Integer, String> answer = giftPaperAnswerList.stream().collect(Collectors.toMap(TbGiftPaperAnswer::getQuestionNo, TbGiftPaperAnswer::getAnswer, (s, a) -> a));

        //报告ID
        String reportId = Utils.uuid();
        //用户答案表
        List<TbGiftUserAnswer> giftUserAnswerList = Lists.newArrayList();

        //听力答案信息
        int listenRightCount = 0;
        float listenScore = 0f;
        for (int i = 0; i < submitAnswerVo.getListenAnswers().size(); i++) {
            ObjectiveAnswerVo objectiveAnswerVo = submitAnswerVo.getListenAnswers().get(i);
            TbGiftUserAnswer giftUserAnswer = fillTbGiftUserAnswer(null, null, giftPeriodPaper, answer, authEntity, reportId,
                    objectiveAnswerVo.getNo(), objectiveAnswerVo.getAnswer(), QuestionType.LISTEN.getValue(), TeacherEvaluateStatus.NO_EVALUATE);
            if (giftUserAnswer.getIsRight()) {
                listenRightCount = listenRightCount + 1;
            }
            listenScore = giftUserAnswer.getScore() + listenScore;
            giftUserAnswerList.add(giftUserAnswer);
        }

        //阅读答案信息
        int readRightCount = 0;
        float readScore = 0f;
        for (int i = 0; i < submitAnswerVo.getReadAnswers().size(); i++) {
            ObjectiveAnswerVo objectiveAnswerVo = submitAnswerVo.getReadAnswers().get(i);
            TbGiftUserAnswer giftUserAnswer = fillTbGiftUserAnswer(null, null, giftPeriodPaper, answer, authEntity, reportId,
                    objectiveAnswerVo.getNo(), objectiveAnswerVo.getAnswer(), QuestionType.READ.getValue(), TeacherEvaluateStatus.NO_EVALUATE);
            if (giftUserAnswer.getIsRight()) {
                readRightCount = readRightCount + 1;
            }
            readScore = giftUserAnswer.getScore() + readScore;
            giftUserAnswerList.add(giftUserAnswer);
        }



        TbGiftReport tbGiftReport = fillTbGiftReport(reportId, giftPeriodPaper, authEntity, listenRightCount,
                submitAnswerVo.getListenAnswers().size(), listenScore, readRightCount, submitAnswerVo.getReadAnswers().size(), readScore);
        float translationScore = 0f;
        float writingScore = 0f;

        if (checkNeedSystemCorrect) {


            String translationAnswerStr = submitAnswerVo.getTranslationAnswers().getAnswer();
            if (Strings.isNullOrEmpty(translationAnswerStr)) {
                tbGiftReport.setScoreTranslate((int) translationScore);
            } else {
                //写入答案表，
                //翻译答案
                TbGiftUserAnswer translationAnswer = fillTbGiftUserAnswer(null, null, giftPeriodPaper, answer, authEntity, reportId,
                        submitAnswerVo.getTranslationAnswers().getNo(), translationAnswerStr, QuestionType.TRANSLATION.getValue(), TeacherEvaluateStatus.TASCHER_EVALUATE);
                giftUserAnswerList.add(translationAnswer);
            }

            String writingAnswerStr = submitAnswerVo.getWritingAnswers().getAnswer();
            if (Strings.isNullOrEmpty(writingAnswerStr)) {
                tbGiftReport.setScoreWrite((int) writingScore);
            } else {
                //写作答案
                TbGiftUserAnswer writingAnswer = fillTbGiftUserAnswer(null, null, giftPeriodPaper, answer, authEntity, reportId,
                        submitAnswerVo.getWritingAnswers().getNo(), writingAnswerStr, QuestionType.WRITING.getValue(), TeacherEvaluateStatus.TASCHER_EVALUATE);
                giftUserAnswerList.add(writingAnswer);
            }
            if (Strings.isNullOrEmpty(writingAnswerStr) && Strings.isNullOrEmpty(translationAnswerStr)) {
                tbGiftReport.setTeacherEvaluateStatus(TeacherEvaluateStatus.NO_EVALUATE);
            } else {
                //需要系统批改
                tbGiftReport.setTeacherEvaluateStatus(TeacherEvaluateStatus.TASCHER_EVALUATE);
            }

        } else {
            tbGiftReport.setTeacherEvaluateStatus(TeacherEvaluateStatus.NO_EVALUATE);

            List<String> ruleDetailIdList = submitAnswerVo.getTranslationAnswers().getAnswerRules().stream().map(SubjectiveAnswerVoDetailIdVo::getRuleDetailId).collect(Collectors.toList());
            ruleDetailIdList.addAll(submitAnswerVo.getWritingAnswers().getAnswerRules().stream().map(SubjectiveAnswerVoDetailIdVo::getRuleDetailId).collect(Collectors.toList()));
            Map<String, Float> subjectiveRuleDetailScore = giftSubjectiveRuleDetailMapper.findByIdList(ruleDetailIdList).stream().collect(Collectors.toMap(TbGiftSubjectiveRuleDetail::getId, TbGiftSubjectiveRuleDetail::getScore));

            //主观题答案表
            List<TbGiftUserAnswerSubjective> giftUserAnswerSubjectiveList = new ArrayList<>();
            //翻译答案
            String translationAnswerId = Utils.uuid();
            //需要自评
            translationScore = submitAnswerVo.getTranslationAnswers().getAnswerRules().stream().map(subjectiveAnswerVoDetailIdVo -> {
                TbGiftUserAnswerSubjective giftUserAnswerSubjective = fillUserAnswerSubjectve(subjectiveRuleDetailScore, translationAnswerId, subjectiveAnswerVoDetailIdVo.getRuleId(), subjectiveAnswerVoDetailIdVo.getRuleDetailId());
                giftUserAnswerSubjectiveList.add(giftUserAnswerSubjective);
                return giftUserAnswerSubjective.getScore();
            }).reduce((a, b) -> a + b).get();

            TbGiftUserAnswer translationAnswer = fillTbGiftUserAnswer(translationAnswerId, translationScore, giftPeriodPaper, answer, authEntity, reportId,
                    submitAnswerVo.getTranslationAnswers().getNo(), submitAnswerVo.getTranslationAnswers().getAnswer(), QuestionType.TRANSLATION.getValue(), TeacherEvaluateStatus.NO_EVALUATE);
            giftUserAnswerList.add(translationAnswer);


            //写作答案
            String writingAnswerId = Utils.uuid();
            //需要自评的成绩信息
            writingScore = submitAnswerVo.getWritingAnswers().getAnswerRules().stream().map(subjectiveAnswerVoDetailIdVo -> {
                TbGiftUserAnswerSubjective giftUserAnswerSubjective = fillUserAnswerSubjectve(subjectiveRuleDetailScore, writingAnswerId, subjectiveAnswerVoDetailIdVo.getRuleId(), subjectiveAnswerVoDetailIdVo.getRuleDetailId());
                giftUserAnswerSubjectiveList.add(giftUserAnswerSubjective);
                return giftUserAnswerSubjective.getScore();
            }).reduce((a, b) -> a + b).get();
            TbGiftUserAnswer writingAnswer = fillTbGiftUserAnswer(writingAnswerId, writingScore, giftPeriodPaper, answer, authEntity, reportId,
                    submitAnswerVo.getWritingAnswers().getNo(), submitAnswerVo.getWritingAnswers().getAnswer(), QuestionType.WRITING.getValue(), TeacherEvaluateStatus.NO_EVALUATE);
            giftUserAnswerList.add(writingAnswer);

            //写入主观答案表
            userAnswerSubjectiveMapper.insertList(giftUserAnswerSubjectiveList);

        }
        float totalScore = listenScore + readScore + translationScore + writingScore;
        tbGiftReport.setScoreTranslate((int) translationScore);
        tbGiftReport.setScoreWrite((int) writingScore);
        tbGiftReport.setTotalScore(Math.round(totalScore));
        //写入答案表
        userAnswerMapper.insertList(giftUserAnswerList);
        //写入报告
        giftReportMapper.insert(tbGiftReport);
        //修改可用次数\已用次数
        updateSubjectiveSubmitRecord(authEntity, giftPeriodPaper);
        return ResponseEntity.ok(new AnswerInfoVo(reportId));

    }

    //修改使用次数记录
    private void updateSubjectiveSubmitRecord(AuthEntity authEntity, TbGiftPeriodPaper giftPeriodPaper) {
        TbGiftSubjectiveSubmitRecord tbGiftSubjectiveSubmitRecord = new TbGiftSubjectiveSubmitRecord();
        tbGiftSubjectiveSubmitRecord.setUserId(authEntity.getUserId());
        tbGiftSubjectiveSubmitRecord.setSectionCode(giftPeriodPaper.getSectionCode());
        switch (giftPeriodPaper.getPeriod()) {
            case PeriodType.PRE: {
                tbGiftSubjectiveSubmitRecordMapper.updatePreUse(authEntity.getUserId(), giftPeriodPaper.getSectionCode());
                break;
            }
            case PeriodType.MID: {
                tbGiftSubjectiveSubmitRecordMapper.updateMidUse(authEntity.getUserId(), giftPeriodPaper.getSectionCode());
                break;
            }
            case PeriodType.POST: {
                tbGiftSubjectiveSubmitRecordMapper.updatePostUse(authEntity.getUserId(), giftPeriodPaper.getSectionCode());
                break;
            }
        }
    }

    /**
     * 填充报告信息
     *
     * @param reportId          报告ID
     * @param giftPeriodPaper   当前试卷信息
     * @param authEntity        当前登录信息
     * @param listenRightCount  听力正确答案数量
     * @param listenQuestionNum 听力题目数量
     * @param listenScore       听力成绩
     * @param readRightCount    阅读正确答案数量
     * @param readQuestionNum   阅读题目数量
     * @param readScore         阅读成绩
     * @return 报告信息
     */
    private TbGiftReport fillTbGiftReport(String reportId, TbGiftPeriodPaper giftPeriodPaper, AuthEntity authEntity, Integer listenRightCount, Integer listenQuestionNum, float listenScore, Integer readRightCount, Integer readQuestionNum, float readScore) {
        TbGiftReport tbGiftReport = new TbGiftReport();
        tbGiftReport.preInsert();
        tbGiftReport.setId(reportId);
        tbGiftReport.setSectionCode(giftPeriodPaper.getSectionCode());
        tbGiftReport.setPeriod(giftPeriodPaper.getPeriod());
        tbGiftReport.setPaperId(giftPeriodPaper.getId());
        tbGiftReport.setUserId(authEntity.getUserId());
        tbGiftReport.setIsSkip(0);
        tbGiftReport.setScoreListen(Math.round(listenScore));
        tbGiftReport.setScoreRead(Math.round(readScore));
        tbGiftReport.setListenRightCount(listenRightCount);
        tbGiftReport.setListenTotalCount(listenQuestionNum);
        tbGiftReport.setReadRightCount(readRightCount);
        tbGiftReport.setReadTotalCount(readQuestionNum);
        tbGiftReport.setSort(giftPeriodPaper.getPeriod());
        return tbGiftReport;
    }

    /**
     * 填充主观题目信息
     *
     * @param subjectiveRuleDetailScore 主观题目信息
     * @param answerId                  用户答案ID
     * @param ruleId                    规则ID
     * @param ruleDetailId              规则详情ID
     * @return 主观题目信息
     */
    private TbGiftUserAnswerSubjective fillUserAnswerSubjectve(Map<String, Float> subjectiveRuleDetailScore, String answerId, String ruleId, String ruleDetailId) {
        float score = subjectiveRuleDetailScore.get(ruleDetailId);
        TbGiftUserAnswerSubjective giftUserAnswerSubjective = new TbGiftUserAnswerSubjective();
        giftUserAnswerSubjective.preInsert();
        giftUserAnswerSubjective.setAnswerId(answerId);
        giftUserAnswerSubjective.setScore(score);
        giftUserAnswerSubjective.setRuleId(ruleId);
        giftUserAnswerSubjective.setRuleDetailId(ruleDetailId);
        giftUserAnswerSubjective.setSort(0);
        return giftUserAnswerSubjective;
    }

    //四六级成绩计算规则
    // 计算小题的分数
    private float calculateScore(int questionNo, boolean answerStatus) {
        float currentQuestionScore = 0f;
        if (!answerStatus) {
            return currentQuestionScore;
        }
        if (questionNo > 0 && questionNo <= 15) {
            //长对话 8% 8个题目
            currentQuestionScore = 7.1f;
        } else if (questionNo > 15 && questionNo <= 25) {
            //听力篇章 20% 共10个小题
            currentQuestionScore = 14.2f;
        } else if (questionNo > 25 && questionNo <= 35) {
            //词汇理解 5% 10个题
            currentQuestionScore = 3.55f;
        } else if (questionNo > 35 && questionNo <= 45) {
            //长篇阅读 10% 10个题
            currentQuestionScore = 7.1f;
        } else if (questionNo > 45 && questionNo <= 55) {
            //仔细阅读 20% 10个题
            currentQuestionScore = 14.2f;
        }
        return currentQuestionScore;
    }


    /**
     * 填充用户答案
     *
     * @param userAnswerId      用户答案ID,如果不传递使用自动生成的
     * @param scoreSelf         自评成绩
     * @param giftPeriodPaper   试卷信息
     * @param answer            答案信息
     * @param authEntity        登录用户
     * @param reportId          报告ID
     * @param questionNo        题号
     * @param userAnswer        用户答案
     * @param questionType      问题类型{@link QuestionType}
     * @param isTeacherEvaluate 是否需要老师批改:0否（自主评分），1是（针对翻译和写作）{@link TeacherEvaluateStatus}
     * @return 用户答案
     */
    private TbGiftUserAnswer fillTbGiftUserAnswer(String userAnswerId, Float scoreSelf, TbGiftPeriodPaper giftPeriodPaper, Map<Integer, String> answer, AuthEntity authEntity, String reportId, int questionNo, String userAnswer, int questionType, int isTeacherEvaluate) {
        String answerValue = answer.get(questionNo);
        TbGiftUserAnswer giftUserAnswer = new TbGiftUserAnswer();
        giftUserAnswer.preInsert();
        giftUserAnswer.setReportId(reportId);
        giftUserAnswer.setPaperId(giftPeriodPaper.getId());
        giftUserAnswer.setUserId(authEntity.getUserId());
        giftUserAnswer.setPeriod(giftPeriodPaper.getPeriod());
        giftUserAnswer.setQuestionType(questionType);
        giftUserAnswer.setQuestionNo(questionNo);
        giftUserAnswer.setRightAnswer(answerValue);
        giftUserAnswer.setUserAnswer(userAnswer);
        giftUserAnswer.setIsTeacherEvaluate(isTeacherEvaluate);
        if (isTeacherEvaluate == TeacherEvaluateStatus.NO_EVALUATE && (questionType == QuestionType.TRANSLATION.getValue() || questionType == QuestionType.WRITING.getValue())) {
            //需要自评、并且是翻译写作才会需要自评分数
            giftUserAnswer.setScore(scoreSelf);
        }
        //只有听力和阅读时才会计算成绩
        if (questionType == QuestionType.LISTEN.getValue() || questionType == QuestionType.READ.getValue()) {
            Boolean isRight = answerValue.equals(userAnswer);
            giftUserAnswer.setIsRight(isRight);
            giftUserAnswer.setScore(calculateScore(questionNo, isRight));
        }
        if (!Strings.isNullOrEmpty(userAnswerId)) {
            giftUserAnswer.setId(userAnswerId);
        }
        giftUserAnswer.setSort(questionNo);
        return giftUserAnswer;
    }

}
