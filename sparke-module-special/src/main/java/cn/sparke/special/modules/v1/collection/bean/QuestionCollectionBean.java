package cn.sparke.special.modules.v1.collection.bean;

import cn.sparke.core.common.bean.BaseEntity;

import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 2017/7/14.
 */
public class QuestionCollectionBean extends BaseEntity{
    //用户id
    private String userId;
    //题目id
    private String questionId;
    //结构id
    @NotNull
    private String structureId;
    //学段
    private int sectionCode;
    //类型(1.全真考场 2.字幕听力 3.简系列 4.专项练习)
    private Integer type;
    //内容类型(1.听力 2.阅读 3.翻译 4.写作)
    @NotNull
    private Integer contentType;
    //拓展字段
    //收藏的小题id
    private String questionItemId;
    //结构名称
    private String structureName;
    //题目名称
    private String name;
    //题目内容
    private String content;
    //题目数量
    private Integer num;

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

    public String getStructureId() {
        return structureId;
    }

    public void setStructureId(String structureId) {
        this.structureId = structureId;
    }

    public int getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(int sectionCode) {
        this.sectionCode = sectionCode;
    }

    public String getStructureName() {
        return structureName;
    }

    public void setStructureName(String structureName) {
        this.structureName = structureName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
