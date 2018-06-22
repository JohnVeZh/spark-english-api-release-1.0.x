package cn.sparke.order.modules.v1.order.bean;

import cn.sparke.order.modules.v1.order.entity.OrderDetailsEntity;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zhangbowen on 2017/7/13.
 */
public class ConfirmOrderBean {
    private BigDecimal totalProductPrice;
    private BigDecimal postage;
    private int isSend;
    private int isPostage;
    private int productNum;
    private AddressBean defaultAddress;
    private List<OrderDetailsEntity> productList;
    private List<CouponBean> couponList;

    public BigDecimal getTotalProductPrice() {
        return totalProductPrice;
    }

    public void setTotalProductPrice(BigDecimal totalProductPrice) {
        this.totalProductPrice = totalProductPrice;
    }

    public BigDecimal getPostage() {
        return postage;
    }

    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }

    public int getIsSend() {
        return isSend;
    }

    public void setIsSend(int isSend) {
        this.isSend = isSend;
    }

    public int getIsPostage() {
        return isPostage;
    }

    public void setIsPostage(int isPostage) {
        this.isPostage = isPostage;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public AddressBean getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(AddressBean defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public List<OrderDetailsEntity> getProductList() {
        return productList;
    }

    public void setProductList(List<OrderDetailsEntity> productList) {
        this.productList = productList;
    }

    public List<CouponBean> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<CouponBean> couponList) {
        this.couponList = couponList;
    }
}
