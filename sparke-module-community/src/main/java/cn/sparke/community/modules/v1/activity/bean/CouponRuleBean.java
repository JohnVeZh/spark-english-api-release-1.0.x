package cn.sparke.community.modules.v1.activity.bean;

import cn.sparke.core.common.bean.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yangye    2017/7/11 13:27
 */
public class CouponRuleBean extends BaseEntity {
    private String gainSceneId;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date effectDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date invalidDate;
    private BigDecimal minMoney;
    private BigDecimal discountMoney;
    private Integer isGain;

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

    public Integer getIsGain() {
        return isGain;
    }

    public void setIsGain(Integer isGain) {
        this.isGain = isGain;
    }
}
