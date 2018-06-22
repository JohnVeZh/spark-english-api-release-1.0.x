package cn.sparke.gift.modules.v1.estimate.bean.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * 估分报告
 */
public class EstimateReport {
    /** 是否跳过 0否，1是 */
    private int isSkip;
    /** 教师批改状态 0不需要老师评分，1老师评分中，2老师评分已提交 */
    private int teacherEvaluateStatus;
    /** 用户总分 int类型 */
    private int totalScore;
    /** 听力得分int类型 */
    private int scoreListen;
    /** 称号列表 */
    private List<Title> titles;
    /** 听力评语 */
    private String listenSuggestion;
    /** 阅读得分 */
    private int scoreRead;
    /** 阅读评语 */
    private String readSuggestion;
    /** 翻译得分 */
    private int scoreTranslate;
    /** 翻译评语 */
    private String translateSuggestion;
    /** 写作得分 */
    private int scoreWrite;
    /** 写作评语 */
    private String writeSuggestion;
    /** 听力题目数 */
    private int listenTotalCount;
    /** 听力作对题目数 */
    private int listenRightCount;
    /** 阅读题目数 */
    private int readTotalCount;
    /** 阅读做对题目数 */
    private int readRightCount;
    /** 翻译批改内容 */
    private String translateReplyContent;
    /** 翻译题试题id */
    @JsonIgnore
    private String translateAnswerId;
    /** 翻译题师傅提交0 已提交 1 未提交 */
    private int translateSubmit;
    /** 用户翻译自主评分 */
    private List<UserEstimate> translateUserEstimate;
    /** 写作批改内容 */
    private String writeReplyContent;
    /** 写作题试题id */
    @JsonIgnore
    private String writeAnswerId;
    /** 用户是否提交写作题 0 已提交 1 未提交 */
    private int writeSubmit;
    /** 用户写作自主评分 */
    private List<UserEstimate> writeUserEstimate;


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

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getScoreListen() {
        return scoreListen;
    }

    public void setScoreListen(int scoreListen) {
        this.scoreListen = scoreListen;
    }

    public List<Title> getTitles() {
        return titles;
    }

    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }

    public String getListenSuggestion() {
        return listenSuggestion;
    }

    public void setListenSuggestion(String listenSuggestion) {
        this.listenSuggestion = listenSuggestion;
    }

    public int getScoreRead() {
        return scoreRead;
    }

    public void setScoreRead(int scoreRead) {
        this.scoreRead = scoreRead;
    }

    public String getReadSuggestion() {
        return readSuggestion;
    }

    public void setReadSuggestion(String readSuggestion) {
        this.readSuggestion = readSuggestion;
    }

    public int getScoreTranslate() {
        return scoreTranslate;
    }

    public void setScoreTranslate(int scoreTranslate) {
        this.scoreTranslate = scoreTranslate;
    }

    public String getTranslateSuggestion() {
        return translateSuggestion;
    }

    public void setTranslateSuggestion(String translateSuggestion) {
        this.translateSuggestion = translateSuggestion;
    }

    public int getScoreWrite() {
        return scoreWrite;
    }

    public void setScoreWrite(int scoreWrite) {
        this.scoreWrite = scoreWrite;
    }

    public String getWriteSuggestion() {
        return writeSuggestion;
    }

    public void setWriteSuggestion(String writeSuggestion) {
        this.writeSuggestion = writeSuggestion;
    }

    public int getListenTotalCount() {
        return listenTotalCount;
    }

    public void setListenTotalCount(int listenTotalCount) {
        this.listenTotalCount = listenTotalCount;
    }

    public int getListenRightCount() {
        return listenRightCount;
    }

    public void setListenRightCount(int listenRightCount) {
        this.listenRightCount = listenRightCount;
    }

    public int getReadTotalCount() {
        return readTotalCount;
    }

    public void setReadTotalCount(int readTotalCount) {
        this.readTotalCount = readTotalCount;
    }

    public int getReadRightCount() {
        return readRightCount;
    }

    public void setReadRightCount(int readRightCount) {
        this.readRightCount = readRightCount;
    }

    public String getTranslateReplyContent() {
        return translateReplyContent;
    }

    public void setTranslateReplyContent(String translateReplyContent) {
        this.translateReplyContent = translateReplyContent;
    }

    public String getTranslateAnswerId() {
        return translateAnswerId;
    }

    public void setTranslateAnswerId(String translateAnswerId) {
        this.translateAnswerId = translateAnswerId;
    }

    public int getTranslateSubmit() {
        return translateSubmit;
    }

    public void setTranslateSubmit(int translateSubmit) {
        this.translateSubmit = translateSubmit;
    }

    public List<UserEstimate> getTranslateUserEstimate() {
        return translateUserEstimate;
    }

    public void setTranslateUserEstimate(List<UserEstimate> translateUserEstimate) {
        this.translateUserEstimate = translateUserEstimate;
    }

    public String getWriteReplyContent() {
        return writeReplyContent;
    }

    public void setWriteReplyContent(String writeReplyContent) {
        this.writeReplyContent = writeReplyContent;
    }

    public String getWriteAnswerId() {
        return writeAnswerId;
    }

    public void setWriteAnswerId(String writeAnswerId) {
        this.writeAnswerId = writeAnswerId;
    }

    public int getWriteSubmit() {
        return writeSubmit;
    }

    public void setWriteSubmit(int writeSubmit) {
        this.writeSubmit = writeSubmit;
    }

    public List<UserEstimate> getWriteUserEstimate() {
        return writeUserEstimate;
    }

    public void setWriteUserEstimate(List<UserEstimate> writeUserEstimate) {
        this.writeUserEstimate = writeUserEstimate;
    }
}
