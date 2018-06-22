package cn.sparke.core.modules.cacheable.memcache;

import net.spy.memcached.MemcachedClient;
import org.springframework.cache.support.AbstractValueAdaptingCache;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MemcachedCache extends AbstractValueAdaptingCache {

    private static final String KEY_DELIMITER = "_";

    private final MemcachedClient memcachedClient;
    private final MemcacheCacheMetadata memcacheCacheMetadata;

    private final Lock lock = new ReentrantLock();

    MemcachedCache(String name, MemcachedClient memcachedClient, int expiration, String prefix) {
        super(true);
        this.memcachedClient = memcachedClient;
        this.memcacheCacheMetadata = new MemcacheCacheMetadata(name, expiration, prefix);
    }

    @Override
    protected Object lookup(Object key) {
        return memcachedClient.get(new MemcachedKey(key).value());
    }

    @Override
    public String getName() {
        return this.memcacheCacheMetadata.name();
    }

    @Override
    public Object getNativeCache() {
        return this.memcachedClient;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        Object value = lookup(key);
        if (value != null) {
            return (T) fromStoreValue(value);
        }

        lock.lock();
        try {
            value = lookup(key);
            if (value != null) {
                return (T) fromStoreValue(value);
            } else {
                return loadValue(key, valueLoader);
            }
        } finally {
            lock.unlock();
        }
    }

    private <T> T loadValue(Object key, Callable<T> valueLoader) {
        T value;
        try {
            value = valueLoader.call();
        } catch (Exception e) {
            throw new ValueRetrievalException(key, valueLoader, e);
        }
        put(key, value);
        return value;
    }

    @Override
    public void put(Object key, Object value) {
        this.memcachedClient.set(new MemcachedKey(key).value(), this.memcacheCacheMetadata.expiration(), value);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        Object existingValue = lookup(key);
        if (existingValue == null) {
            put(key, value);
            return toValueWrapper(value);
        }

        return toValueWrapper(existingValue);
    }

    @Override
    public void evict(Object key) {
        this.memcachedClient.delete(new MemcachedKey(key).value());
    }

    @Override
    public void clear() {
        this.memcachedClient.incr(this.memcacheCacheMetadata.cachePrefix, 1);
    }

    /**
     * Wrapper class for the Memcached key value.
     * <p>
     * All whitespace characters will be stripped from the key value, for Memcached
     * key to be valid.
     */
    class MemcachedKey {
        private final StringBuilder value;

        MemcachedKey(Object key) {
            this.value = new StringBuilder(memcacheCacheMetadata.cachePrefix())
                    .append(KEY_DELIMITER)
                    .append(String.valueOf(key).replaceAll("\\s", ""));
        }

        String value() {
            return this.value.toString();
        }

    }

    class MemcacheCacheMetadata {
        private final String name;
        private final int expiration;
        private final String cachePrefix;

        MemcacheCacheMetadata(String name, int expiration, String cachePrefix) {
            this.name = name;
            this.expiration = expiration;

            this.cachePrefix = cachePrefix +
                    KEY_DELIMITER +
                    name;
        }

        public String name() {
            return name;
        }

        int expiration() {
            return expiration;
        }

        String cachePrefix() {
            return cachePrefix;
        }
    }
}