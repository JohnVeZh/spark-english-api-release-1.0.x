package cn.sparke.special.modules.v1.report.bean;

import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 2017/7/23.
 */
public class ScoreBean {
    private String name; //专项名称
    @NotNull
    private int type;//类型模块类型(1. 听力 2. 阅读 3.翻译 4.写作 5.背单词
    private float abilityValue;// 能力值 比例值
    @NotNull
    private float score;//分数
    private float totalScore;//此单项总分

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getAbilityValue() {
        return abilityValue;
    }

    public void setAbilityValue(float abilityValue) {
        this.abilityValue = abilityValue;
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
}
