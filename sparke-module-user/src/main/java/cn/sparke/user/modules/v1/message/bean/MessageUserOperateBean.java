package cn.sparke.user.modules.v1.message.bean;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public class MessageUserOperateBean extends BaseEntity{
    private String userId;
    private String msgId;
    private int type;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
