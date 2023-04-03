package com.example.rabbitmqapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {

    @Value("${spring.data.redis.host}")
    private String hostName;
    @Value("${spring.data.redis.port}")
    private int port;

    @Bean
    public JedisConnectionFactory redisConnectionFactory(){
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(hostName);
        configuration.setPort(port);
        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfigBuilder
                = JedisClientConfiguration.builder();
        return new JedisConnectionFactory(configuration, jedisClientConfigBuilder.build());
    }

    @Bean
    public RedisTemplate<String,Object> redisTemplate(){
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());
        return template;
    }
}
