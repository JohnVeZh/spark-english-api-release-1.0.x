package cn.sparke.gift.modules.v1.estimate.bean.po;

public class TbGiftReportSuggestConfig {

    private String content;
    private int startScore;
    private int endScore;
    private int questionType;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStartScore() {
        return startScore;
    }

    public void setStartScore(int startScore) {
        this.startScore = startScore;
    }

    public int getEndScore() {
        return endScore;
    }

    public void setEndScore(int endScore) {
        this.endScore = endScore;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }
}
