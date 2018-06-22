package cn.sparke;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by zhangbowen on 2017/4/11.
 */
@ComponentScan(nameGenerator = SpecialApplication.SpringBeanNameGenerator.class)
@SpringBootApplication
@MapperScan(value = "**.mapper", markerInterface = BaseMapper.class, nameGenerator = SpecialApplication.SpringBeanNameGenerator.class)
@EnableEurekaClient
@EnableFeignClients
//implements EmbeddedServletContainerCustomizer
public class SpecialApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpecialApplication.class);
    }

    //    @Override
//    public void customize(ConfigurableEmbeddedServletContainer container) {
//        container.setPort(9090);
//    }

    public static class SpringBeanNameGenerator extends AnnotationBeanNameGenerator {
        @Override
        protected String buildDefaultBeanName(BeanDefinition definition) {
            return definition.getBeanClassName();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SpecialApplication.class, args);
    }

}
