package cn.sparke;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by wanghaiguang on 2017/7/10.
 */
@ComponentScan(nameGenerator = ScanApplication.SpringBeanNameGenerator.class)
@SpringBootApplication
@MapperScan(value = "**.mapper",markerInterface = BaseMapper.class, nameGenerator = ScanApplication.SpringBeanNameGenerator.class)
@EnableEurekaClient
@EnableFeignClients
public class ScanApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ScanApplication.class);
    }

    public static class SpringBeanNameGenerator extends AnnotationBeanNameGenerator {
        @Override
        protected String buildDefaultBeanName(BeanDefinition definition) {
            return definition.getBeanClassName();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ScanApplication.class, args);
    }

}
