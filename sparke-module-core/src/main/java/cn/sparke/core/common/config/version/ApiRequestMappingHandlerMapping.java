package cn.sparke.core.common.config.version;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * Created by zhangbowen on 2017/7/8.
 */
public class ApiRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        return createCondition(method.getClass());
    }

    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        return createCondition(handlerType);
    }
    private static RequestCondition<ApiVersionCondition> createCondition(Class<?> clazz) {
        RequestMapping classRequestMapping = AnnotationUtils.findAnnotation(clazz, RequestMapping.class);
        if (classRequestMapping == null) {
            return null;
        }
        StringBuilder mappingUrlBuilder = new StringBuilder();
        if (classRequestMapping.value().length > 0) {
            mappingUrlBuilder.append(classRequestMapping.value()[0]);
        }
        String mappingUrl = mappingUrlBuilder.toString();
        if (!mappingUrl.contains("${version}")) {
            return null;
        }
        ApiVersion apiVersion = AnnotationUtils.findAnnotation(clazz, ApiVersion.class);
        return apiVersion == null ? new ApiVersionCondition(1) : new ApiVersionCondition(apiVersion.value());
    }
}
