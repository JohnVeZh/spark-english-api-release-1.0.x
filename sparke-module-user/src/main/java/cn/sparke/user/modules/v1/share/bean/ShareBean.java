package cn.sparke.user.modules.v1.share.bean;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public class ShareBean extends BaseEntity {
    private String userId;
    private String content;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
