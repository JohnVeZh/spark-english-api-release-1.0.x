package cn.sparke.special.modules.v1.word.bean;

import cn.sparke.core.common.bean.BaseEntity;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by Administrator on 2017/7/11.
 */
public class WordCatalogBean extends BaseEntity {
    private String name;//名称
    private String code;//
    private String parentId;//父id
    private String parentIds;//父id集合 以英文逗号,分隔
    private Integer sectionCode;//	学段
    private Integer level;//	级别
    private Integer isLeaf;//是否是叶子节点(0.否 1.是)
    private Integer type;//类型（1.常用词汇 2.专项练习 ）
    private Integer totalNum; //单词总数
    private Integer didNum;//已学习单词数量
    private BigDecimal rightRate;//正确率
    private String iconUrl;//图标路径

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Integer getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(Integer sectionCode) {
        this.sectionCode = sectionCode;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getDidNum() {
        return didNum;
    }

    public void setDidNum(Integer didNum) {
        this.didNum = didNum;
    }

    public BigDecimal getRightRate() {
        return rightRate;
    }

    public void setRightRate(BigDecimal rightRate) {
        this.rightRate = rightRate;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
