package cn.sparke.order.modules.v1.order.bean;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public class PostOrderProductBean {
    private String shoppingCarId;
    @NotBlank
    private String productId;
    @NotNull
    @Min(1)
    private int productNum;

    public String getShoppingCarId() {
        return shoppingCarId;
    }

    public void setShoppingCarId(String shoppingCarId) {
        this.shoppingCarId = shoppingCarId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }
}
