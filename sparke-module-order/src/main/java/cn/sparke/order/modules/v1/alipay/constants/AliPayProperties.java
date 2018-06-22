package cn.sparke.order.modules.v1.alipay.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zhangbowen on 2017/7/14.
 */
@ConfigurationProperties(prefix = "project.ali.pay")
@Component
public class AliPayProperties {
    public String app_id;
    public String private_key;
    public String public_key;
    public String notify_url;
    public String pc_return_url;
    public String m_return_url;
    public String server_url;

    public String getServer_url() {
        return server_url;
    }

    public void setServer_url(String server_url) {
        this.server_url = server_url;
    }

    public String getM_return_url() {
        return m_return_url;
    }

    public void setM_return_url(String m_return_url) {
        this.m_return_url = m_return_url;
    }

    public String getPc_return_url() {
        return pc_return_url;
    }

    public void setPc_return_url(String pc_return_url) {
        this.pc_return_url = pc_return_url;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getPrivate_key() {
        return private_key;
    }

    public void setPrivate_key(String private_key) {
        this.private_key = private_key;
    }

    public String getPublic_key() {
        return public_key;
    }

    public void setPublic_key(String public_key) {
        this.public_key = public_key;
    }
}
