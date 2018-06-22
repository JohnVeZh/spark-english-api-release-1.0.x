package cn.sparke.special.modules.v1.collection.bean;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by Administrator on 2017/7/16.
 */
public class QuestionCollectionDetailBean extends BaseEntity {
    //收藏id
    private String collectionId;
    //结构id
    private String structureId;
    //用户id
    private String userId;
    //题目id
    private String questionId;
    //收藏的小题id
    private String questionItemId;
    //类型(1.全真考场 2.字幕听力 3.简系列 4.专项练习)
    private Integer type;
    //内容类型(1.听力 2.阅读 3.翻译 4.写作)
    private Integer contentType;

    public void setCollectionId(String collectionId){
        this.collectionId=collectionId;
    }
    public String getCollectionId(){
        return this.collectionId;
    }
    public void setStructureId(String structureId){
        this.structureId=structureId;
    }
    public String getStructureId(){
        return this.structureId;
    }
    public void setUserId(String userId){
        this.userId=userId;
    }
    public String getUserId(){
        return this.userId;
    }
    public void setQuestionId(String questionId){
        this.questionId=questionId;
    }
    public String getQuestionId(){
        return this.questionId;
    }
    public void setQuestionItemId(String questionItemId){
        this.questionItemId=questionItemId;
    }
    public String getQuestionItemId(){
        return this.questionItemId;
    }
    public void setType(Integer type){
        this.type=type;
    }
    public Integer getType(){
        return this.type;
    }
    public void setContentType(Integer contentType){
        this.contentType=contentType;
    }
    public Integer getContentType(){
        return this.contentType;
    }
}
