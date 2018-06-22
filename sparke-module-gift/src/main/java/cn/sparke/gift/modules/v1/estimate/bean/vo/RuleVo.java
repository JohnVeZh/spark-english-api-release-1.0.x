package cn.sparke.gift.modules.v1.estimate.bean.vo;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/8/21 10:27
 */
public class RuleVo {

    private String id;
    private String name;
    private Integer questionType;
    private String reference;
    private List<RuleDetailsVo> rulesDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<RuleDetailsVo> getRulesDetails() {
        return rulesDetails;
    }

    public void setRulesDetails(List<RuleDetailsVo> rulesDetails) {
        this.rulesDetails = rulesDetails;
    }
}
