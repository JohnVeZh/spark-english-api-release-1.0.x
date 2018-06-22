package cn.sparke.special.modules.v1.question.bean;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by Administrator on 2017/7/17.
 */
public class WrongBookDetailBean extends BaseEntity {
    //用户id
    private String userId;
    //错题本id
    private String wrongBookId;
    //小题id
    private String questionItemId;
    //题目id
    private String questionId;
    //结构id
    private String structureId;
    //结构名称
    private String structureAlias;
    //试卷id
    private String paperId;
    //用户做题记录详情id
    private String recordDetailsId;

    public void setUserId(String userId){
        this.userId=userId;
    }
    public String getUserId(){
        return this.userId;
    }
    public void setWrongBookId(String wrongBookId){
        this.wrongBookId=wrongBookId;
    }
    public String getWrongBookId(){
        return this.wrongBookId;
    }
    public void setQuestionItemId(String questionItemId){
        this.questionItemId=questionItemId;
    }
    public String getQuestionItemId(){
        return this.questionItemId;
    }
    public void setQuestionId(String questionId){
        this.questionId=questionId;
    }
    public String getQuestionId(){
        return this.questionId;
    }
    public void setStructureId(String structureId){
        this.structureId=structureId;
    }
    public String getStructureId(){
        return this.structureId;
    }
    public void setStructureAlias(String structureAlias){
        this.structureAlias=structureAlias;
    }
    public String getStructureAlias(){
        return this.structureAlias;
    }
    public void setPaperId(String paperId){
        this.paperId=paperId;
    }
    public String getPaperId(){
        return this.paperId;
    }
    public void setRecordDetailsId(String recordDetailsId){
        this.recordDetailsId=recordDetailsId;
    }
    public String getRecordDetailsId(){
        return this.recordDetailsId;
    }
}
