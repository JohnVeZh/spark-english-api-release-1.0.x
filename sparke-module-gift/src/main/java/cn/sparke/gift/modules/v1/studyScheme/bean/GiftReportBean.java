package cn.sparke.gift.modules.v1.studyScheme.bean;

import cn.sparke.core.common.bean.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * @author yangye    2017-08-21
 */
public class GiftReportBean extends BaseEntity{

    private String section;
    private int period;
    private String userId;
    private boolean isSkip;

    private int teacherEvaluateStatus;
    private int totalScore; // userTotalScore
    private int listenTotalCount;
    private int listenRightCount;
    private int scoreListen;
    private int readTotalCount;
    private int readRightCount;
    private int scoreRead;
    private int scoreTranslate;
    private int scoreWrite;

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
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

    public boolean isSkip() {
        return isSkip;
    }

    public void setSkip(boolean skip) {
        isSkip = skip;
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

    public int getScoreListen() {
        return scoreListen;
    }

    public void setScoreListen(int scoreListen) {
        this.scoreListen = scoreListen;
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

    public int getScoreRead() {
        return scoreRead;
    }

    public void setScoreRead(int scoreRead) {
        this.scoreRead = scoreRead;
    }

    public int getScoreTranslate() {
        return scoreTranslate;
    }

    public void setScoreTranslate(int scoreTranslate) {
        this.scoreTranslate = scoreTranslate;
    }

    public int getScoreWrite() {
        return scoreWrite;
    }

    public void setScoreWrite(int scoreWrite) {
        this.scoreWrite = scoreWrite;
    }
}
