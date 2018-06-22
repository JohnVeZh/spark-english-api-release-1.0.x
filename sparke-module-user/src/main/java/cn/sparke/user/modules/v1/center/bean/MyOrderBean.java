package cn.sparke.user.modules.v1.center.bean;

import cn.sparke.core.common.bean.BaseEntity;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public class MyOrderBean<T> extends BaseEntity {
    private String orderCode;
    private Integer orderStatus;
    private BigDecimal orderPrice;
    private List<T> orderDetailsList;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public List<T> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<T> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }
}
