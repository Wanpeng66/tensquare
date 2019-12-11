package com.wp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author: wp
 * @Title: RedisConfig
 * @Description: TODO
 * @date 2019/12/11 20:17
 */
@Configuration
public class Config {
@Autowired
RedisConnectionFactory redisConnectionFactory;


    @Bean
    public RedisTemplate<String,String> redisTemplate( ){
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory( redisConnectionFactory );
        return redisTemplate;
    }

    @Bean
    public MongoTemplate mongoTemplate( MongoDbFactory mongoDbFactory ){
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
        return mongoTemplate;
    }

    //@Bean
    public ApplicationRunner applicationRunner(){
        RedisTemplate<String, String> redisTemplate = redisTemplate(  );
        ApplicationRunner applicationRunner = new ApplicationRunner() {
            @Override
            public void run( ApplicationArguments args ) throws Exception {

            }
        };
        return applicationRunner;
    }
}
