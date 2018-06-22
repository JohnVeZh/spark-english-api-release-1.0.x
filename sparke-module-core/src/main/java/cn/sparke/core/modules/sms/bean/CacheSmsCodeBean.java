package cn.sparke.core.modules.sms.bean;

import java.io.Serializable;

/**
 * Created by zhangbowen on 2016/1/8.
 * 验证码
 */
public class CacheSmsCodeBean implements Serializable {
    private static final long serialVersionUID = 1L;
    //间隔发送时间
    private int interval;
    //验证码
    private String code;
    //发送时间
    private long sendTime;

    public long getSendTime() {
        return sendTime;
    }

    public void setSendTime(long sendTime) {
        this.sendTime = sendTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }
}
