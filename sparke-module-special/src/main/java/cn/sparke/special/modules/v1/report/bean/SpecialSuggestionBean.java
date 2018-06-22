package cn.sparke.special.modules.v1.report.bean;

import cn.sparke.core.common.bean.BaseEntity;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/7/16.
 */
public class SpecialSuggestionBean extends BaseEntity {
    private String name;
    private float score;
    private float totalScore;
    private Integer type;
    private String analysis;
    private String suggestion;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(float totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }
}
