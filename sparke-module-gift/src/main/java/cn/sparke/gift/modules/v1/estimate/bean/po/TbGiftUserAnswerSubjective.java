package cn.sparke.gift.modules.v1.estimate.bean.po;

import cn.sparke.core.common.bean.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class TbGiftUserAnswerSubjective extends BaseEntity{

    private String answerId;

    private String ruleId;

    private String ruleDetailId;

    private float score;

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleDetailId() {
        return ruleDetailId;
    }

    public void setRuleDetailId(String ruleDetailId) {
        this.ruleDetailId = ruleDetailId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}