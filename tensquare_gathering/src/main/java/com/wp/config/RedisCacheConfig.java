package com.wp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: wp
 * @Title: RedisCacheConfig
 * @Description: TODO
 * @date 2019/12/8 20:31
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {
    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisTemplate<String,Object> stringObjectRedisCache(){
        RedisTemplate<String,Object> stringObjectRedisTemplate = new RedisTemplate<>();
        RedisSerializer stringSerializer = new StringRedisSerializer();
        stringObjectRedisTemplate.setKeySerializer(stringSerializer);
        stringObjectRedisTemplate.setConnectionFactory(redisConnectionFactory);
        return stringObjectRedisTemplate;
    }

    @Bean
    public CacheManager redisCacheManager(){
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
        //全局的缓存配置
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig();
        //过期时间为1小时
        defaultCacheConfig.entryTtl( Duration.ofHours(1) );
        //自定义的缓存配置
        RedisCacheConfiguration userCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().
                entryTtl(Duration.ofSeconds( 100L ));
        //将缓存名与缓存配置关联起来
        redisCacheConfigurationMap.put("tensquare_gathering", userCacheConfiguration);

        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(redisConnectionFactory);
        builder.withInitialCacheConfigurations( redisCacheConfigurationMap );
        RedisCacheManager redisCacheManager  = builder.build();

        return redisCacheManager;
    }

    // 自定义key生成器
    @Bean
    public KeyGenerator customerkeyGenerator(){
        return (o, method, params) ->{
            StringBuilder sb = new StringBuilder();
            sb.append(o.getClass().getName()); // 类名
            sb.append(method.getName()); // 方法名
            for(Object param: params){
                sb.append(param.toString()); // 参数名
            }
            return sb.toString();
        };
    }
}
