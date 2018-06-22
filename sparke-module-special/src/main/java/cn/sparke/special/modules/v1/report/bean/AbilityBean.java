package cn.sparke.special.modules.v1.report.bean;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/7/16.
 */
public class AbilityBean {
    private float score;
    private int wrongWordNum;
    private int collectionNum;
    private int wrongQuestionNum;
    private int recordNum;
    private List<ScoreBean> scoreList;

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getWrongWordNum() {
        return wrongWordNum;
    }

    public void setWrongWordNum(int wrongWordNum) {
        this.wrongWordNum = wrongWordNum;
    }

    public int getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(int collectionNum) {
        this.collectionNum = collectionNum;
    }

    public int getWrongQuestionNum() {
        return wrongQuestionNum;
    }

    public void setWrongQuestionNum(int wrongQuestionNum) {
        this.wrongQuestionNum = wrongQuestionNum;
    }

    public int getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(int recordNum) {
        this.recordNum = recordNum;
    }

    public List<ScoreBean> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<ScoreBean> scoreList) {
        this.scoreList = scoreList;
    }
}
