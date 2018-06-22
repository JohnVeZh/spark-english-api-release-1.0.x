package cn.sparke.easy.modules.v1.papers.bean;

import cn.sparke.core.common.bean.BaseEntity;

import java.util.List;

/**
 * Created by john on 2017/7/10.
 * 试卷结构实体
 */
public class PaperStructureBean extends BaseEntity {

    private String paperId; //试卷id
    private String name; //试卷结构名称(part 1 section one)
    private String content;//
    private String alias; //别名(写作 阅读 section one)
    private String parentId; //父id
    private Integer level; //级别
    private Integer isLeaf; //是否叶子叶点(1.否 1.是)(叶子节点才会存在题目)

    private List<QuestionBean> itemList;



    //非数据库字段
    private Integer total; //总题数

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<QuestionBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<QuestionBean> itemList) {
        this.itemList = itemList;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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
}
