package com.boot3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

@Configuration
public class RedisConfig {
    // PUB-SUB 채팅 기능 구현시 사용하는 config

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    RedisMessageListenerContainer redisMessageListenerContainer (){
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory());
        return container;
    }
}
