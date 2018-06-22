package cn.sparke.special.modules.v1.record.bean;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by Administrator on 2017/7/14.
 */
public class QuestionRecordDetailBean extends BaseEntity {
    private String userId;//用户id
    private String questionRecordId;//题目做题记录id
    private String questionItemId;//	小题id
    private String questionId;//题目id
    private Integer status	;//	状态(1.正确 2.错误 3.未做)
    private String userOptionId;//用户选项id
    private String rightOptionId;//	正确选项id

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuestionRecordId() {
        return questionRecordId;
    }

    public void setQuestionRecordId(String questionRecordId) {
        this.questionRecordId = questionRecordId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserOptionId() {
        return userOptionId;
    }

    public void setUserOptionId(String userOptionId) {
        this.userOptionId = userOptionId;
    }

    public String getRightOptionId() {
        return rightOptionId;
    }

    public void setRightOptionId(String rightOptionId) {
        this.rightOptionId = rightOptionId;
    }
}
