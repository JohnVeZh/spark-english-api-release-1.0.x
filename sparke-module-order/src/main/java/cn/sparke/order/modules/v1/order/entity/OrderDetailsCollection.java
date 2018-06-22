package cn.sparke.order.modules.v1.order.entity;

import cn.sparke.core.common.bean.BaseEntity;

import java.math.BigDecimal;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public class OrderDetailsCollection extends BaseEntity {
    private String parentProductId;
    private String orderDetailId;
    private String productId;
    private BigDecimal productPrice;
    private String productName;
    private String productImg;
    private Integer type;
    private Integer num;

    public String getParentProductId() {
        return parentProductId;
    }

    public void setParentProductId(String parentProductId) {
        this.parentProductId = parentProductId;
    }

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
