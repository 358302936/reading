package com.hx.reader.components.shiro;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import com.hx.reader.redis.ICached;
/**
 * redis的缓存管理器
 *
 */
public class ShiroRedisCacheManager extends AbstractCacheManager {
	private ICached cached;
	@SuppressWarnings("rawtypes")
	@Override
	protected Cache createCache(String cacheName) throws CacheException {
		return new ShiroRedisCache<String, Object>(cacheName,cached);
	}
	public ICached getCached() {
		return cached;
	}
	public void setCached(ICached cached) {
		this.cached = cached;
	}

}
