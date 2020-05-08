package com.myproject.taskscheduler.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    private CacheManager cacheManager;

    @Autowired
    public CacheService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    /**
     * Cache service method use for clearing the {@link Cache} <br>
     * using the clazzName of the object. Example of cacheKey: <br>
     * <p>
     * <blockquote>
     * <pre>
     * <br>
     *      "ServiceClassName.getAll"
     * </pre>
     * </blockquote>
     * <br>
     * <tt>ServiceClassName</tt> - the clazz name of the object. <br>
     * <tt>getAll</tt> - the clazz method of the object. <br>
     *
     * @param className the class name of the object.
     */
    public void evictCachedByClassName(Class<?> className) {

        // Get the class name
        String clazzName = className.getSimpleName();

        // Iterate available form the cache manager
        for (String cacheName : cacheManager.getCacheNames()) {

            // Get the token of the cacheName. Separate by dot(.)
            // [0] - className of the object or service. E.g ServiceClassName
            // [1] - method name of the object or service. E.g getAll
            String[] tokenizer = cacheName.split(". ");

            // Check if the cacheName contains the className in the string.
            boolean isContain = tokenizer.length > 0 && tokenizer[0].contains(clazzName);

            // If isContain return true. It means the className exist in
            // cache manager so clear the cache with the use of cacheName.
            if (isContain) {
                evictCacheByName(cacheName);
            }
        }
    }

    /**
     * Service function use to evict a certain cache by <br>
     * providing the cacheName.
     *
     * @param cacheName The Cache name.
     */
    public void evictCacheByName(String cacheName) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache != null) {
            cache.clear();
        }
    }
}
