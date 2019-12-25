package com.wp.config;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.RabbitConnectionFactoryBean;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author: wp
 * @Title: Config
 * @Description: TODO
 * @date 2019/12/23 21:10
 */
@Configuration
public class Config {
    @Autowired
    RedisConnectionFactory redisConnectionFactory;


    @Bean
    public RedisTemplate<String,String> redisTemplate(){
        RedisTemplate<String,String> stringObjectRedisTemplate = new RedisTemplate<>();
        RedisSerializer stringSerializer = new StringRedisSerializer();
        stringObjectRedisTemplate.setKeySerializer(stringSerializer);
        stringObjectRedisTemplate.setConnectionFactory(redisConnectionFactory);
        return stringObjectRedisTemplate;
    }


}
