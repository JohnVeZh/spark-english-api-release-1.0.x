package cn.sparke.user.modules.v1.share.bean;

import javax.validation.constraints.NotNull;

public class ShareContent {
    @NotNull
    private Integer type;
    private String contentId;
    private String content;
    private int wordNum;
    private double graspRate;
    private int reviewNum;
    private int graspNum;
    private int studyNum;
    private int historyNum;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getWordNum() {
        return wordNum;
    }

    public void setWordNum(int wordNum) {
        this.wordNum = wordNum;
    }

    public double getGraspRate() {
        return graspRate;
    }

    public void setGraspRate(double graspRate) {
        this.graspRate = graspRate;
    }

    public int getReviewNum() {
        return reviewNum;
    }

    public void setReviewNum(int reviewNum) {
        this.reviewNum = reviewNum;
    }

    public int getGraspNum() {
        return graspNum;
    }

    public void setGraspNum(int graspNum) {
        this.graspNum = graspNum;
    }

    public int getStudyNum() {
        return studyNum;
    }

    public void setStudyNum(int studyNum) {
        this.studyNum = studyNum;
    }

    public int getHistoryNum() {
        return historyNum;
    }

    public void setHistoryNum(int historyNum) {
        this.historyNum = historyNum;
    }
}
