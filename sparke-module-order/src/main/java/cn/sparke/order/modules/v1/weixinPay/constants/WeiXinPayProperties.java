package cn.sparke.order.modules.v1.weixinPay.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zhangbowen on 2017/7/14.
 */
@ConfigurationProperties(prefix = "project.weixin.pay")
@Component
public class WeiXinPayProperties {
    public String app_id;
    public String mch_id;
    public String notify_url;
    public String pay_key;

    public String getPay_key() {
        return pay_key;
    }

    public void setPay_key(String pay_key) {
        this.pay_key = pay_key;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }
}
