package cn.sparke.gift.modules.v1.studyScheme.bean;

import cn.sparke.core.common.utils.Utils;

import java.util.Date;

/**
 * 报告
 */
public class TBGiftReport {
    private String id;
    private int sectionCode;
    private int period;
    private String userId;
    private int isSkip;
    private int teacherEvaluateStatus;
    private float totalScore;
    private float scoreListen;
    private float scoreRead;
    private float scoreTranslate;
    private float scoreWrite;
    private int listenTotalCount;
    private int listenRightCount;
    private int readTotalCount;
    private int readRightCount;
    private Date create_date;
    private String createBy;
    private Date updateDate;
    private String updateBy;
    private String remarks;
    private int sort;
    private int delFlag;

    public TBGiftReport(String userId,int sectionCode,int isSkip){
        this.id= Utils.uuid();
        this.sectionCode=sectionCode;
        this.create_date=new Date();
        this.updateDate=new Date();
        this.userId=userId;
        this.createBy=userId;
        this.updateBy=userId;
        this.isSkip=isSkip;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(float totalScore) {
        this.totalScore = totalScore;
    }

    public float getScoreListen() {
        return scoreListen;
    }

    public void setScoreListen(float scoreListen) {
        this.scoreListen = scoreListen;
    }

    public float getScoreRead() {
        return scoreRead;
    }

    public void setScoreRead(float scoreRead) {
        this.scoreRead = scoreRead;
    }

    public float getScoreTranslate() {
        return scoreTranslate;
    }

    public void setScoreTranslate(float scoreTranslate) {
        this.scoreTranslate = scoreTranslate;
    }

    public float getScoreWrite() {
        return scoreWrite;
    }

    public void setScoreWrite(float scoreWrite) {
        this.scoreWrite = scoreWrite;
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

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }
}
