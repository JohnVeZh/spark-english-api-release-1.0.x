package cn.sparke.user.modules.v1.coupons.bean;

import cn.sparke.core.common.bean.BaseEntity;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public class CouponGainRecordBean extends BaseEntity {
    private String userId;
    private String couponId;
    private String gainSceneId;
    private String ruleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getGainSceneId() {
        return gainSceneId;
    }

    public void setGainSceneId(String gainSceneId) {
        this.gainSceneId = gainSceneId;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }
}
