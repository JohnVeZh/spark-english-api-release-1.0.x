package cn.sparke.user.modules.v1.favorities.bean;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by zhangbowen on 2017/7/10.
 */
public class CancelFavoriteBean {
    @NotBlank
    private String targetId;

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }
}
