package cn.sparke.support.modules.v1.exam.bean.submit.po;

import cn.sparke.core.common.bean.BaseEntity;

import java.util.Date;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/13 16:13
 */
public class TbQuestionWrongBook extends BaseEntity {

    private int sectionCode;
    /**
     * 用户id
     */
    private String userId;

    private int type;

    /**
     * 题目id
     */
    private String questionId;

    /**
     * 试卷id
     */
    private String paperId;


    private String structureId;

    private String structureAlias;

    public int getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(int sectionCode) {
        this.sectionCode = sectionCode;
    }

    public String getStructureId() {
        return structureId;
    }

    public void setStructureId(String structureId) {
        this.structureId = structureId;
    }

    public String getStructureAlias() {
        return structureAlias;
    }

    public void setStructureAlias(String structureAlias) {
        this.structureAlias = structureAlias;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

}
