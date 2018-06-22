package cn.sparke.gift.modules.v1.studyScheme.bean;

import cn.sparke.core.common.bean.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yangye    2017-08-21
 */
public class RecommendCourseBean extends BaseEntity{

    private String productId;
    private String name;
    private Integer catalogNumber;
    private Integer saleNum;
    private String listImg;
    private String coverImg;
    private BigDecimal presentPrice;
    private BigDecimal originalPrice;
    // private BigDecimal giftBookPrice;
    private Integer isLive;
    private Date startTime;
    private Date endTime;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(Integer catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public String getListImg() {
        return listImg;
    }

    public void setListImg(String listImg) {
        this.listImg = listImg;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public BigDecimal getPresentPrice() {
        return presentPrice;
    }

    public void setPresentPrice(BigDecimal presentPrice) {
        this.presentPrice = presentPrice;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getIsLive() {
        return isLive;
    }

    public void setIsLive(Integer isLive) {
        this.isLive = isLive;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
