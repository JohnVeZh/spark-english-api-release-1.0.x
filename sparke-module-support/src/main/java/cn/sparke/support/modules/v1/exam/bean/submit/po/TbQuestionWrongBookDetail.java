package cn.sparke.support.modules.v1.exam.bean.submit.po;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/20 15:22
 */
public class TbQuestionWrongBookDetail extends BaseEntity {


    /**
     * 用户id
     */
    private String userId;

    /**
     * 错题本id
     */
    private String wrongBookId;

    /**
     * 小题id
     */
    private String questionItemId;

    /**
     * 题目id
     */
    private String questionId;

    /**
     * 结构id
     */
    private String structureId;

    /**
     * 结构名称
     */
    private String structureAlias;

    /**
     * 试卷id
     */
    private String paperId;

    /**
     * 用户做题记录详情id
     */
    private String recordDetailsId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWrongBookId() {
        return wrongBookId;
    }

    public void setWrongBookId(String wrongBookId) {
        this.wrongBookId = wrongBookId;
    }

    public String getQuestionItemId() {
        return questionItemId;
    }

    public void setQuestionItemId(String questionItemId) {
        this.questionItemId = questionItemId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
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

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getRecordDetailsId() {
        return recordDetailsId;
    }

    public void setRecordDetailsId(String recordDetailsId) {
        this.recordDetailsId = recordDetailsId;
    }
}
