package cn.sparke.core.modules.sms;

import cn.sparke.core.modules.sms.service.LMobile.LmobileSmsService;
import cn.sparke.core.modules.sms.service.LMobile.constants.LmobileSmsProperties;
import cn.sparke.core.modules.sms.service.local.LocalSmsService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhangbowen on 2017/5/5.
 */
@Configuration
public class SmsAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean(ISmsService.class)
    @ConditionalOnProperty(prefix = "project", value = "sms", havingValue = "lmobile")
    public ISmsService aliSmsService(LmobileSmsProperties lmobileSmsProperties) {
        return new LmobileSmsService(lmobileSmsProperties);
    }

    @Bean
    @ConditionalOnMissingBean(ISmsService.class)
    public ISmsService basicSmsService() {
        return new LocalSmsService();
    }
}
