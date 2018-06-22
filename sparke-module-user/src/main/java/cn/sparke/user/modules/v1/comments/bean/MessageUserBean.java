package cn.sparke.user.modules.v1.comments.bean;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public class MessageUserBean extends BaseEntity{
    private String userId;
    private String msgId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
