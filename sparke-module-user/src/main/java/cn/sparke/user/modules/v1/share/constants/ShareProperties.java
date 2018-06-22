package cn.sparke.user.modules.v1.share.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "project")
@Component
public class ShareProperties {
    public String shareBaseUrl;
    public String mUrl;

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getShareBaseUrl() {
        return shareBaseUrl;
    }

    public void setShareBaseUrl(String shareBaseUrl) {
        this.shareBaseUrl = shareBaseUrl;
    }
}
