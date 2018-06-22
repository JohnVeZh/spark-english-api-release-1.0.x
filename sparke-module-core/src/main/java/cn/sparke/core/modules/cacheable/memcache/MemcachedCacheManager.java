package cn.sparke.core.modules.cacheable.memcache;

import net.spy.memcached.MemcachedClient;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MemcachedCacheManager implements CacheManager {
    private ConcurrentMap<String, Cache> cacheMap = new ConcurrentHashMap<>();
    private String cachePrefix = "";
    private static final int expiration = 60 * 30;//缓存三十分钟

    private MemcachedClient memcachedClient;

    public MemcachedCacheManager(String cacheSuffix, MemcachedClient memcachedClient) {
        this.cachePrefix = cacheSuffix;
        this.memcachedClient = memcachedClient;
    }

    @Override
    public Cache getCache(String name) {
        Cache cache = this.cacheMap.get(name);
        if (cache == null) {
            cache = new MemcachedCache(name, memcachedClient, expiration, cachePrefix);
            final Cache currentCache = cacheMap.putIfAbsent(name, cache);
            if (currentCache != null) {
                cache = currentCache;
            }
        }
        return cache;
    }

    @Override
    public Collection<String> getCacheNames() {
        return Collections.unmodifiableSet(cacheMap.keySet());
    }
}