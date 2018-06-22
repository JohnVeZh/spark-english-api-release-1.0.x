package cn.sparke.special.modules.v1.word.bean;

import cn.sparke.core.common.bean.BaseEntity;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/7/12.
 */
public class WordUserReportBean extends BaseEntity {
    private Integer sectionCode;//学段
    private String userId;//用户ID
    private String catalogId;//目录id
    private String parentCatalogIds;//	父id集合 以英文逗号,分隔
    private Integer totalNum;//总数量
    private Integer rightNum;//正确数量
    private Integer wrongNum;	//错误数量
    private BigDecimal rightRate;//正确率

    public Integer getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(Integer sectionCode) {
        this.sectionCode = sectionCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getParentCatalogIds() {
        return parentCatalogIds;
    }

    public void setParentCatalogIds(String parentCatalogIds) {
        this.parentCatalogIds = parentCatalogIds;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getRightNum() {
        return rightNum;
    }

    public void setRightNum(Integer rightNum) {
        this.rightNum = rightNum;
    }

    public Integer getWrongNum() {
        return wrongNum;
    }

    public void setWrongNum(Integer wrongNum) {
        this.wrongNum = wrongNum;
    }

    public BigDecimal getRightRate() {
        return rightRate;
    }

    public void setRightRate(BigDecimal rightRate) {
        this.rightRate = rightRate;
    }
}
