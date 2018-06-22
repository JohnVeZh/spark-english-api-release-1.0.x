package cn.sparke.goods.modules.v1.book.bean;

import cn.sparke.core.common.bean.BaseEntity;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author yangye    2017/7/11
 */
public class ProductBookBean extends BaseEntity{

    private String productId;
    private String name;
    private String brief;
    private String content;
    private Integer type;
    private String listImg;
    private String coverImg;
    private String contentImgs;
    private String sectionCode;
    private BigDecimal presentPrice;
    private BigDecimal originalPrice;
    private Integer saleNum;
    private Integer evaluateStar;
    private Integer evaluateNum;
    private Integer isShow;
    private Integer isSend;
    private Integer isPostage;
    private Integer isPromotion;
    private BigDecimal postage;

    private String presss;
    private Integer typeId;

    private Integer isLike;
    private Integer hasCoupon;
    private List<CouponRuleBean> couponRuleList;

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

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getContentImgs() {
        return contentImgs;
    }

    public void setContentImgs(String contentImgs) {
        this.contentImgs = contentImgs;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
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

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Integer getEvaluateStar() {
        return evaluateStar;
    }

    public void setEvaluateStar(Integer evaluateStar) {
        this.evaluateStar = evaluateStar;
    }

    public Integer getEvaluateNum() {
        return evaluateNum;
    }

    public void setEvaluateNum(Integer evaluateNum) {
        this.evaluateNum = evaluateNum;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getIsSend() {
        return isSend;
    }

    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }

    public Integer getIsPostage() {
        return isPostage;
    }

    public void setIsPostage(Integer isPostage) {
        this.isPostage = isPostage;
    }

    public Integer getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(Integer isPromotion) {
        this.isPromotion = isPromotion;
    }

    public BigDecimal getPostage() {
        return postage;
    }

    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }

    public String getPresss() {
        return presss;
    }

    public void setPresss(String presss) {
        this.presss = presss;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getIsLike() {
        return isLike;
    }

    public void setIsLike(Integer isLike) {
        this.isLike = isLike;
    }

    public Integer getHasCoupon() {
        return hasCoupon;
    }

    public void setHasCoupon(Integer hasCoupon) {
        this.hasCoupon = hasCoupon;
    }

    public List<CouponRuleBean> getCouponRuleList() {
        return couponRuleList;
    }

    public void setCouponRuleList(List<CouponRuleBean> couponRuleList) {
        this.couponRuleList = couponRuleList;
    }
}
