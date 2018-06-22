package cn.sparke.user.modules.v1.coupons.bean;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public class CouponDrawBean {
    @NotNull
    @Range(min = 1, max = 2)
    private Integer type;
    @NotBlank
    private String contentId;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }
}
