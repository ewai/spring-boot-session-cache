package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {

    @Bean
    public CacheManager cacheManager(RedisTemplate<Object,Object> redisTemplate) {

        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

        Map<String, Long> expires = new HashMap<String, Long>();
        expires.put("cache.day", new Long(24 * 60 * 60));
        expires.put("cache.short", new Long(3 * 60));
        cacheManager.setExpires(expires);
        return cacheManager;
    }
}