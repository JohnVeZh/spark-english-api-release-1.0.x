package cn.sparke.core.common.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zhangbowen on 2017/5/5.
 * 必须要有get set 方法，不然无法注入
 */
@ConfigurationProperties(prefix = "project")
@Component
public class ProjectProperties {
    public String cache;
    public String sms;
    public String cacheSuffix;

    public String getCache() {
        return cache;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getCacheSuffix() {
        return cacheSuffix;
    }

    public void setCacheSuffix(String cacheSuffix) {
        this.cacheSuffix = cacheSuffix;
    }
}
