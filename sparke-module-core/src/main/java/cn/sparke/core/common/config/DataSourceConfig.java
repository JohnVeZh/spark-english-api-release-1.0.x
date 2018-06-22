package cn.sparke.core.common.config;

import cn.sparke.core.common.constants.DruidProperties;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus配置
 *
 * @author sparke
 * @Date 2017/5/20 21:58
 */
@Configuration
public class DataSourceConfig {

    @Autowired
    private DruidProperties druidProperties;

    /**
     * spark的数据源
     */
    private DruidDataSource dataSourceGuns() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    /**
     * 数据源连接池配置
     */
    @Bean
    public DruidDataSource singleDatasource() {
        return dataSourceGuns();
    }
}
