package cn.sparke.special.modules.v1.paper.bean;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by Administrator on 2017/7/10.
 */
public class PaperBean extends BaseEntity{
    private String catalogId;//目录id
    private String name;//名称
    private String code;
    private String img;	//试卷图片
    private String parentId;//	父id
    private Integer level;	//级别
    private Integer isLeaf;//	是否为叶子节点(0.否 1.是)
    private Integer total;//总题数
    private Integer didNum;//已做数量
    private Integer questionNum;//题目总数
    //拓展字段 子查询用
//    private String userId;
//    private int sectionCode;
    private int contentType;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getDidNum() {
        return didNum;
    }

    public void setDidNum(Integer didNum) {
        this.didNum = didNum;
    }

//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

//    public int getSectionCode() {
//        return sectionCode;
//    }
//
//    public void setSectionCode(int sectionCode) {
//        this.sectionCode = sectionCode;
//    }


    public Integer getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(Integer questionNum) {
        this.questionNum = questionNum;
    }
}
