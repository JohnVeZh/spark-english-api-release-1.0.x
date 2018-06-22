package cn.sparke.base.modules.v1.banners.bean;

import cn.sparke.core.common.bean.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zhangbowen on 2017/7/10.
 */
public class CouponRuleBean extends BaseEntity {
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date effectDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date invalidDate;
    //优惠券规则场景关系id
    private String gainSceneId;
    private BigDecimal minMoney;
    private int isGain;
    private BigDecimal discountMoney;

    public int getIsGain() {
        return isGain;
    }

    public void setIsGain(int isGain) {
        this.isGain = isGain;
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
}
