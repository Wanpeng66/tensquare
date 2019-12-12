package com.wp.config;

import com.mongodb.AuthenticationMechanism;
import com.mongodb.MongoCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
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
    @Autowired
    MongoProperties mongoProperties;

    @Bean
    public RedisTemplate<String,String> redisTemplate( ){
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory( redisConnectionFactory );
        return redisTemplate;
    }

    //@Bean
    public MongoClientFactoryBean mongoClientFactoryBean() {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        mongo.setHost( mongoProperties.getHost() );
        mongo.setPort( mongoProperties.getPort() );
        mongo.setCredentials( new MongoCredential[]{
                MongoCredential.createScramSha1Credential( mongoProperties.getUsername(),mongoProperties.getDatabase(),mongoProperties.getPassword())
        } );
        return mongo;
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
