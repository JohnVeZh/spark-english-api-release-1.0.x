package cn.sparke.core.modules.sms.service.LMobile.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zhangbowen on 2017/7/8.
 */
@ConfigurationProperties(prefix = "project.lmobile")
@Component
public class LmobileSmsProperties {
    public String url;
    public String sname;
    public String spwd;
    public String sprdid;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpwd() {
        return spwd;
    }

    public void setSpwd(String spwd) {
        this.spwd = spwd;
    }

    public String getSprdid() {
        return sprdid;
    }

    public void setSprdid(String sprdid) {
        this.sprdid = sprdid;
    }
}
