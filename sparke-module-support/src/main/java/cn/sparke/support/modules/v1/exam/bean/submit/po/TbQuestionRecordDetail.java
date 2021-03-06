package cn.sparke.support.modules.v1.exam.bean.submit.po;

import cn.sparke.core.common.bean.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 20:24
 */
public class TbQuestionRecordDetail extends BaseEntity {


    /**
     * 用户id
     */
    private String userId;

    private String questionId;

    /**
     * 题目做题记录id
     */
    private String questionRecordId;

    /**
     * 小题id
     */
    private String questionItemId;

    /**
     * 状态(1.正确 2.错误 3.未做)
     */
    private int status;

    /**
     * 用户选项id
     */
    private String userOptionId;

    /**
     * 正确选项id
     */
    private String rightOptionId;


    /**
     * 排序
     */
  
    private Integer sort;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

    @Override
    public Integer getSort() {
        return sort;
    }

    @Override
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
