/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.sparke.core.modules.cacheable.memcache;

import cn.sparke.core.common.constants.ProjectProperties;
import cn.sparke.core.modules.cache.CacheAutoConfiguration;
import cn.sparke.core.modules.cache.constants.IntegrationTestCacheProperties;
import cn.sparke.core.modules.cache.constants.OcsProperties;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * 自动注入memcache cacheable
 * @author zhangbowen
 */
@Configuration
@EnableCaching
@ConditionalOnMissingBean(CacheManager.class)
@AutoConfigureBefore(CacheAutoConfiguration.class)
public class MemCacheConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "project.cache", value = "level", havingValue = "test")
    public MemcachedCacheManager cacheManager(ProjectProperties projectProperties, IntegrationTestCacheProperties integrationTestCacheProperties) throws IOException {
        return new MemcachedCacheManager(projectProperties.cacheSuffix, MemcachedBuilder.getInstance(integrationTestCacheProperties.url, integrationTestCacheProperties.port));
    }

    @Bean
    @ConditionalOnProperty(prefix = "project.cache", value = "level", havingValue = "ali")
    public MemcachedCacheManager aliCacheManager(ProjectProperties projectProperties, OcsProperties ocsProperties) {
        return new MemcachedCacheManager(projectProperties.cacheSuffix, MemcachedBuilder.getInstance(ocsProperties.uid, ocsProperties.pwd, ocsProperties.url));
    }

}
