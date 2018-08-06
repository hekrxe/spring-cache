package com.simple.config;

import com.simple.serializer.ProtostuffRedisSerializer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * User: tanhuayou
 * Date: 2018/7/28
 */
@Configuration
@EnableCaching
public class RedisCacheConfig {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setTestOnBorrow(true);

        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setDatabase(0);
        factory.setHostName("localhost");
        factory.setPort(6379);
        factory.setPoolConfig(config);
        factory.setUsePool(true);
        factory.afterPropertiesSet();

        return factory;
    }

    @Bean("dbRedisTemplate")
    public RedisTemplate dbRedisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        GenericJackson2JsonRedisSerializer defaultSerializer = new GenericJackson2JsonRedisSerializer();
        ProtostuffRedisSerializer protostuffRedisSerializer = new ProtostuffRedisSerializer();

        redisTemplate.setConnectionFactory(jedisConnectionFactory());

        redisTemplate.setDefaultSerializer(defaultSerializer);
        redisTemplate.setValueSerializer(protostuffRedisSerializer);

        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    @Bean("cacheManager")
    public CacheManager cacheManager() {

        RedisCacheManager cacheManager = new RedisCacheManager(dbRedisTemplate());
        cacheManager.setUsePrefix(true);

        return cacheManager;
    }


}
