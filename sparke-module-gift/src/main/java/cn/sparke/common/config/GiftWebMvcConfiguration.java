package cn.sparke.common.config;

import cn.sparke.common.interceotor.ActiveInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Ning
 * 2017/8/25.
 */
@Configuration
@Order
public class GiftWebMvcConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new ActiveInterceptor()).addPathPatterns("/**");
    }
}
