package cn.sparke.gift.modules.v1.estimate.bean.po;

import cn.sparke.core.common.bean.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class TbGiftSubjectiveRule extends BaseEntity {

    private int sectionCode;

    /**
     * 题目类型，1听力，2阅读，3翻译，4写作（仅3、4可用）
     */
    private int questionType;

    /**
     * 规则名称
     */
    private String name;


    public int getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(int sectionCode) {
        this.sectionCode = sectionCode;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}