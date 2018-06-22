package cn.sparke.order.modules.v1.order.entity;

import cn.sparke.core.common.bean.BaseEntity;
import cn.sparke.order.modules.v1.order.constants.OrderConstants;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public class OrderDetailsEntity extends BaseEntity {
    private String orderId;
    private String orderCode;
    private String productId;
    private Integer num;
    private Integer productType;
    private String productName;
    private String productImg;
    private BigDecimal productPrice;
    private BigDecimal dealPrice;
    private BigDecimal discountPrice;
    private Integer hasCollection;
    private Integer isSend;
    private Integer isPostage;
    private BigDecimal postage;
    private String networkCourseId;
    private String redeemId;
    private int refundStatus;
    private int isComment;
    private List<OrderDetailsCollection> orderDetailsCollectionList;


    public int getIsComment() {
        return isComment;
    }

    public void setIsComment(int isComment) {
        this.isComment = isComment;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(int refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getRedeemId() {
        return redeemId;
    }

    public void setRedeemId(String redeemId) {
        this.redeemId = redeemId;
    }


    public String getNetworkCourseId() {
        return networkCourseId;
    }

    public void setNetworkCourseId(String networkCourseId) {
        this.networkCourseId = networkCourseId;
    }

    public Integer getIsPostage() {
        return isPostage;
    }

    public void setIsPostage(Integer isPostage) {
        this.isPostage = isPostage;
    }

    public Integer getIsSend() {
        return isSend;
    }

    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }

    public BigDecimal getPostage() {
        return postage;
    }

    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }

    public List<OrderDetailsCollection> getOrderDetailsCollectionList() {
        return orderDetailsCollectionList;
    }

    public void setOrderDetailsCollectionList(List<OrderDetailsCollection> orderDetailsCollectionList) {
        this.orderDetailsCollectionList = orderDetailsCollectionList;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Integer getHasCollection() {
        if (this.orderDetailsCollectionList != null && this.orderDetailsCollectionList.size() > 0) {
            return OrderConstants.HAS_COLLECTION;
        }
        return OrderConstants.UN_HAS_COLLECTION;
    }

    public void setHasCollection(Integer hasCollection) {
        this.hasCollection = hasCollection;
    }
}
