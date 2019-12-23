package com.wp.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author: wp
 * @Title: Config
 * @Description: TODO
 * @date 2019/12/23 21:10
 */
@Configuration
public class Config {

    @Bean
    public RedisTemplate<String,String> redisTemplate(){
        return new RedisTemplate<String,String>();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(){
        return new RabbitTemplate(  );
    }
}
