package com.example.rabbitmqapp.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${rabbitmq.queue.name}")
    private String queue;
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Bean
    public CachingConnectionFactory connectionFactory(){
        return new CachingConnectionFactory("localhost");

    }
//
//    @Bean
//    public AmqpAdmin amqpAdmin(){
//        return new RabbitAdmin(connectionFactory());
//    }
    @Bean
    public MessageConverter messageConverter(){

        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
//    @Bean
//    public RabbitTemplate rabbitTemplate(){
//        return new RabbitTemplate(connectionFactory());
//    }

    @Bean
    public Queue queue(){
        return new Queue(queue);
    }

    @Bean
    public DirectExchange exchange(){
    return new DirectExchange(exchange);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routingKey);
    }
}
