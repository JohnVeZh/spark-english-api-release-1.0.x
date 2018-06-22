package cn.sparke.order.modules.v1.order.entity;

import cn.sparke.core.common.bean.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public class OrderEntity extends BaseEntity {
    private String userId;
    private Integer type;
    private Integer orderStatus;
    private String orderCode;
    private Integer payType;
    private BigDecimal payPrice;
    private BigDecimal orderPrice;
    private BigDecimal totalProductPrice;
    private BigDecimal discountPrice;
    private BigDecimal postagePrice;
    private Integer productNum;
    private Date payTime;
    private String tradeNo;
    private Integer fromType;
    private Integer isSend;
    private String couponId;
    private String redeemId;
    private Integer isAdminDel;
    private Integer isUserDel;
    private String orderTradeNo;
    private OrderLogisticsEntity logisticsInfo;
    private List<OrderDetailsEntity> orderDetailsList;

    public String getOrderTradeNo() {
        return orderTradeNo;
    }

    public void setOrderTradeNo(String orderTradeNo) {
        this.orderTradeNo = orderTradeNo;
    }

    public OrderLogisticsEntity getLogisticsInfo() {
        return logisticsInfo;
    }

    public void setLogisticsInfo(OrderLogisticsEntity logisticsInfo) {
        this.logisticsInfo = logisticsInfo;
    }

    public List<OrderDetailsEntity> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetailsEntity> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public BigDecimal getTotalProductPrice() {
        return totalProductPrice;
    }

    public void setTotalProductPrice(BigDecimal totalProductPrice) {
        this.totalProductPrice = totalProductPrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public BigDecimal getPostagePrice() {
        return postagePrice;
    }

    public void setPostagePrice(BigDecimal postagePrice) {
        this.postagePrice = postagePrice;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Integer getFromType() {
        return fromType;
    }

    public void setFromType(Integer fromType) {
        this.fromType = fromType;
    }

    public Integer getIsSend() {
        return isSend;
    }

    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getRedeemId() {
        return redeemId;
    }

    public void setRedeemId(String redeemId) {
        this.redeemId = redeemId;
    }

    public Integer getIsAdminDel() {
        return isAdminDel;
    }

    public void setIsAdminDel(Integer isAdminDel) {
        this.isAdminDel = isAdminDel;
    }

    public Integer getIsUserDel() {
        return isUserDel;
    }

    public void setIsUserDel(Integer isUserDel) {
        this.isUserDel = isUserDel;
    }
}
