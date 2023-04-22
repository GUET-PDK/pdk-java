package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class RedisConfig {


        @Bean
        public RedisTemplate<Object, Object> MyRedisTemplate(RedisConnectionFactory redisConnectionFactory)
                throws UnknownHostException {
            RedisTemplate<Object, Object> template = new RedisTemplate<>();
            template.setConnectionFactory(redisConnectionFactory);
            // 设置其他的k-v的默认的序列化
            template.setDefaultSerializer(new StringRedisSerializer());
            //单独设置k的序列化
            template.setKeySerializer(new StringRedisSerializer());

            return template;
        }


}
