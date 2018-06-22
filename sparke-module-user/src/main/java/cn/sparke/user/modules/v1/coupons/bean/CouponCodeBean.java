package cn.sparke.user.modules.v1.coupons.bean;

import cn.sparke.core.common.bean.BaseEntity;

import java.util.Date;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public class CouponCodeBean extends BaseEntity {
    private String code;
    private int usedNum;
    private int maxNum;
    private Date effectDate;
    private Date invalidDate;
    private int status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getUsedNum() {
        return usedNum;
    }

    public void setUsedNum(int usedNum) {
        this.usedNum = usedNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
