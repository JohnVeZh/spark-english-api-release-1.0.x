package cn.sparke.order.modules.v1.order.bean;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public class PostOrderBean {
    @NotNull
    @Range(min = 1, max = 2)
    private Integer type;
    private String addressId;
    private String remarks;
    private String couponId;
    @Valid
    @NotEmpty
    private List<PostOrderProductBean> productList;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public List<PostOrderProductBean> getProductList() {
        return productList;
    }

    public void setProductList(List<PostOrderProductBean> productList) {
        this.productList = productList;
    }
}
