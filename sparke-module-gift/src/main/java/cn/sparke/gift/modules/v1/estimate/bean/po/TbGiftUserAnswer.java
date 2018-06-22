package cn.sparke.gift.modules.v1.estimate.bean.po;

import cn.sparke.core.common.bean.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 */
public class TbGiftUserAnswer extends BaseEntity {

    private boolean isRight;

    /**
     * 诊断报告id
     */
    private String reportId;

    /**
     * 试卷id
     */
    private String paperId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 1学前，2学中，3学末
     */
    private Integer period;

    /**
     * 题目类型，1听力，2阅读，3翻译，4写作
     */
    private Integer questionType;

    /**
     * 题号，1,2,3
     */
    private Integer questionNo;


    private String rightAnswer;
    /**
     * 用户答案：客观题选项、老师批改的主观题是上传的图片地址、自主评分的主观题为空
     */
    private String userAnswer;

    /**
     * 是否需要老师批改:0否（自主评分），1是（针对翻译和写作）
     */
    private Integer isTeacherEvaluate;

    /**
     * 得分
     */
    private float score;

    /**
     * 批改老师的ID
     */
    private String replyUserId;

    /**
     * 批改时间
     */
    private Date replyDate;

    public boolean getIsRight() {
        return isRight;
    }

    public void setIsRight(boolean isRight) {
        this.isRight = isRight;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public Integer getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(Integer questionNo) {
        this.questionNo = questionNo;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }




    public String getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(String replyUserId) {
        this.replyUserId = replyUserId;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public Integer getIsTeacherEvaluate() {
        return isTeacherEvaluate;
    }

    public void setIsTeacherEvaluate(Integer isTeacherEvaluate) {
        this.isTeacherEvaluate = isTeacherEvaluate;
    }


}