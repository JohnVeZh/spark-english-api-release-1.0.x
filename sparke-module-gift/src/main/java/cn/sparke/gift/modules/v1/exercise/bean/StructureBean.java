package cn.sparke.gift.modules.v1.exercise.bean;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by Administrator on 2017/7/10.
 */
public class StructureBean extends BaseEntity {
    private String paperId;//	试卷id
    private String name;//	名称
    private String alias;//	别名(写作 阅读 section one)
    private String parentId;//	父id
    private Integer level;//	级别
    private String isLeaf;//	是否叶子叶点(1.否 1.是)(叶子节点才会存在题目)
    private Integer total;//总题数
    private Integer didNum;//已做数量
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

    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
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
}
