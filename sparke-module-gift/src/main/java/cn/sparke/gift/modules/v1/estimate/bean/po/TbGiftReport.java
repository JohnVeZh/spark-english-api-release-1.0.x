package cn.sparke.gift.modules.v1.estimate.bean.po;

import cn.sparke.core.common.bean.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 */
public class TbGiftReport extends BaseEntity {

    /**
     * 学段
     */
    private int sectionCode;

    /**
     * 阶段，1学前，2学中，3学末
     */
    private int period;

    private String paperId;

    private String userId;

    /**
     * 是否是手动跳过，0否，1是
     */
    private int isSkip;

    /**
     * 0不需要老师评分，1老师评分中，2老师评分已提交
     */
    private int teacherEvaluateStatus;

    /**
     * 用户总分
     */
    private Integer totalScore;

    /**
     * 听力得分
     */
    private Integer scoreListen;

    /**
     * 阅读得分
     */
    private Integer scoreRead;

    /**
     * 翻译得分
     */
    private Integer scoreTranslate;

    /**
     * 写作得分
     */
    private Integer scoreWrite;

    /**
     * 听力的题目数
     */
    private Integer listenTotalCount;

    /**
     * 听力作对的题目数
     */
    private Integer listenRightCount;

    /**
     * 阅读总题目数
     */
    private Integer readTotalCount;

    /**
     * 阅读作对的题目数
     */
    private Integer readRightCount;

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public int getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(int sectionCode) {
        this.sectionCode = sectionCode;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getIsSkip() {
        return isSkip;
    }

    public void setIsSkip(int isSkip) {
        this.isSkip = isSkip;
    }

    public int getTeacherEvaluateStatus() {
        return teacherEvaluateStatus;
    }

    public void setTeacherEvaluateStatus(int teacherEvaluateStatus) {
        this.teacherEvaluateStatus = teacherEvaluateStatus;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getScoreListen() {
        return scoreListen;
    }

    public void setScoreListen(Integer scoreListen) {
        this.scoreListen = scoreListen;
    }

    public Integer getScoreRead() {
        return scoreRead;
    }

    public void setScoreRead(Integer scoreRead) {
        this.scoreRead = scoreRead;
    }

    public Integer getScoreTranslate() {
        return scoreTranslate;
    }

    public void setScoreTranslate(Integer scoreTranslate) {
        this.scoreTranslate = scoreTranslate;
    }

    public Integer getScoreWrite() {
        return scoreWrite;
    }

    public void setScoreWrite(Integer scoreWrite) {
        this.scoreWrite = scoreWrite;
    }

    public Integer getListenTotalCount() {
        return listenTotalCount;
    }

    public void setListenTotalCount(Integer listenTotalCount) {
        this.listenTotalCount = listenTotalCount;
    }

    public Integer getListenRightCount() {
        return listenRightCount;
    }

    public void setListenRightCount(Integer listenRightCount) {
        this.listenRightCount = listenRightCount;
    }

    public Integer getReadTotalCount() {
        return readTotalCount;
    }

    public void setReadTotalCount(Integer readTotalCount) {
        this.readTotalCount = readTotalCount;
    }

    public Integer getReadRightCount() {
        return readRightCount;
    }

    public void setReadRightCount(Integer readRightCount) {
        this.readRightCount = readRightCount;
    }
}