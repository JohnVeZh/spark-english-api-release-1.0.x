package cn.sparke.base.modules.v1.fragment.bean;

import cn.sparke.core.common.bean.BaseEntity;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by zhangbowen on 2017/7/10.
 */
public class FeedbackBean extends BaseEntity {
    private String userId;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String content;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
