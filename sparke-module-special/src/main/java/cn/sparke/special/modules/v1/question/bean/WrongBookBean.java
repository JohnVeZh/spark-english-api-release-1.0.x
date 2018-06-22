package cn.sparke.special.modules.v1.question.bean;

import cn.sparke.core.common.bean.BaseEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/7/13.
 */
public class WrongBookBean extends BaseEntity {
    private String userId;//	用户id
    private String questionId;//	题目id
    private int sectionCode;//学段
    private String structureId;//结构id
    private String structureAlias;//	结构名称
    private int type;//1、专项练习2、配套专区
    private String paperId;//试卷id
    //拓展字段
    //结构名称
    private String structureName;
    //题目名称
    private String name;
    //内容
    private String content;
    //题目类型
    private Integer contentType;
    //错题数量
    private Integer num;

    //错题本详情
    private List<WrongBookDetailBean> wrongBookDetailBeanList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }



    public String getStructureId() {
        return structureId;
    }

    public void setStructureId(String structureId) {
        this.structureId = structureId;
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

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<WrongBookDetailBean> getWrongBookDetailBeanList() {
        return wrongBookDetailBeanList;
    }

    public void setWrongBookDetailBeanList(List<WrongBookDetailBean> wrongBookDetailBeanList) {
        this.wrongBookDetailBeanList = wrongBookDetailBeanList;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public int getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(int sectionCode) {
        this.sectionCode = sectionCode;
    }

    public String getStructureAlias() {
        return structureAlias;
    }

    public void setStructureAlias(String structureAlias) {
        this.structureAlias = structureAlias;
    }
}
