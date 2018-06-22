package cn.sparke.gift.modules.v1.estimate.bean.po;

import cn.sparke.core.common.bean.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 */
public class TbGiftSubjectiveRuleDetail extends BaseEntity {

    private String ruleId;

    /**
     * 等级，1差，2中，3好
     */
    private int level;

    /**
     * 分数
     */
    private float score;

    /**
     * 规则详细内容
     */
    private String content;

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}