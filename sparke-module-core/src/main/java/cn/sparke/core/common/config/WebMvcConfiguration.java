package cn.sparke.core.common.config;

import cn.sparke.core.common.interceptor.ContextInterceptor;
import cn.sparke.core.common.interceptor.LogInterceptor;
import cn.sparke.core.common.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zhangbowen on 2017/5/5.
 */
@Configuration
@Order(1)
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
//    @Bean
//    public AlwaysSampler defaultSampler() {
//        return new AlwaysSampler();
//    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new ContextInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
    }
}
