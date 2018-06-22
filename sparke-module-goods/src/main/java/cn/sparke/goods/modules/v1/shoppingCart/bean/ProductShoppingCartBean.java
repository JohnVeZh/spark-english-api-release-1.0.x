package cn.sparke.goods.modules.v1.shoppingCart.bean;

import cn.sparke.core.common.bean.BaseEntity;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author yangye    2017/7/12
 */
public class ProductShoppingCartBean extends BaseEntity {
//    @NotNull
    private String userId;
    @NotNull
    private String productId;
    @NotNull
    @Range(min = 1)
    private Integer productNum;

    private String productName;
    private String productImg;
    private BigDecimal productPrice;

    private int recordCount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
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

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
