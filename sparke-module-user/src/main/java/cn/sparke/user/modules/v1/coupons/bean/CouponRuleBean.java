package cn.sparke.user.modules.v1.coupons.bean;

import cn.sparke.core.common.bean.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public class CouponRuleBean extends BaseEntity {
    //优惠券规则场景关系id
    private String gainSceneId;
    //可使用的商品id
    private String productId;
    private String title;
    private Date effectDate;
    private Date invalidDate;
    private int couponEffectPeriod;
    private BigDecimal minMoney;
    private BigDecimal discountMoney;
    private int status;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getGainSceneId() {
        return gainSceneId;
    }

    public void setGainSceneId(String gainSceneId) {
        this.gainSceneId = gainSceneId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public Date getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(Date invalidDate) {
        this.invalidDate = invalidDate;
    }

    public int getCouponEffectPeriod() {
        return couponEffectPeriod;
    }

    public void setCouponEffectPeriod(int couponEffectPeriod) {
        this.couponEffectPeriod = couponEffectPeriod;
    }

    public BigDecimal getMinMoney() {
        return minMoney;
    }

    public void setMinMoney(BigDecimal minMoney) {
        this.minMoney = minMoney;
    }

    public BigDecimal getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(BigDecimal discountMoney) {
        this.discountMoney = discountMoney;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public CouponBean convertCouponBean(String userId) {
        CouponBean couponBean = new CouponBean();
        couponBean.setRuleId(this.getId());
        couponBean.setProductId(this.getProductId());
        couponBean.setTitle(this.getTitle());
        couponBean.setEffectDate(this.getEffectDate());
        couponBean.setInvalidDate(this.getInvalidDate());
        couponBean.setMinMoney(this.getMinMoney());
        couponBean.setDiscountMoney(this.getDiscountMoney());
        couponBean.setUserId(userId);
        return couponBean;
    }
}
