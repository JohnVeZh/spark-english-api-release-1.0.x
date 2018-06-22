package cn.sparke.core.modules.cache;

import cn.sparke.core.common.constants.ProjectProperties;
import cn.sparke.core.modules.cache.constants.IntegrationTestCacheProperties;
import cn.sparke.core.modules.cache.constants.OcsProperties;
import cn.sparke.core.modules.cache.service.CacheService;
import cn.sparke.core.modules.cache.service.impl.LocalCache;
import cn.sparke.core.modules.cache.service.impl.MemcachedService;
import cn.sparke.core.modules.cacheable.memcache.MemcachedBuilder;
import cn.sparke.core.modules.cacheable.memcache.MemcachedCacheManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhangbowen on 2017/5/5.
 */
@Configuration
public class CacheAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean({CacheService.class, MemcachedCacheManager.class})
    @ConditionalOnProperty(prefix = "project.cache", value = "level", havingValue = "ali")
    public CacheService aliCache(OcsProperties ocsProperties) {
        return new MemcachedService(MemcachedBuilder.getInstance(ocsProperties.uid, ocsProperties.pwd, ocsProperties.url));
    }


    @Bean
    @ConditionalOnMissingBean(CacheService.class)
    @ConditionalOnProperty(prefix = "project.cache", value = "level", havingValue = "test")
    public CacheService testCache(IntegrationTestCacheProperties integrationTestCacheProperties) {
        return new MemcachedService(MemcachedBuilder.getInstance(integrationTestCacheProperties.url, integrationTestCacheProperties.port));
    }

    @Bean
    @ConditionalOnMissingBean(CacheService.class)
    public CacheService localCacheService() {
        return new LocalCache();
    }

    @Bean
    @ConditionalOnBean(CacheService.class)
    public CacheFacade initCache(ProjectProperties projectProperties, CacheService cacheService) {
        return CacheFacade.initCache(projectProperties, cacheService);
    }
}
