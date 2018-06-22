package cn.sparke.user.modules.v1.favorities.bean;

import cn.sparke.core.common.bean.BaseEntity;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * Created by zhangbowen on 2017/7/10.
 */
public class FavoriteBean extends BaseEntity {
    @NotBlank
    @Length(min = 32, max = 32)
    private String targetId;
    @NotNull
    @Range(min = 1, max = 2)
    private Integer type;
    private String userId;

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
