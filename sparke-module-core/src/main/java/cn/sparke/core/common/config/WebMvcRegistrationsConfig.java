package cn.sparke.core.common.config;

import cn.sparke.core.common.config.version.ApiRequestMappingHandlerMapping;
import org.springframework.boot.autoconfigure.web.WebMvcRegistrationsAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Created by zhangbowen on 2017/7/8.
 */
@Configuration
public class WebMvcRegistrationsConfig extends WebMvcRegistrationsAdapter {
    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new ApiRequestMappingHandlerMapping();
    }
}
