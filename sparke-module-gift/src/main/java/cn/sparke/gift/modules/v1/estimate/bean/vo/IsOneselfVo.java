package cn.sparke.gift.modules.v1.estimate.bean.vo;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/8/21 10:26
 */
public class IsOneselfVo {
    private String name;
    private Integer period;
    private String paperId;
    private Integer isOneself;
    private List<RuleVo> ruleList;

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsOneself() {
        return isOneself;
    }

    public void setIsOneself(Integer isOneself) {
        this.isOneself = isOneself;
    }

    public List<RuleVo> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<RuleVo> ruleList) {
        this.ruleList = ruleList;
    }
}
