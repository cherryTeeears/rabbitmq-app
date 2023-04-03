package com.example.rabbitmqapp.domain.producer;

import com.example.rabbitmqapp.controller.dto.EmployeeToPostDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitProducer.class);
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(EmployeeToPostDto employeeToPostDto) {
        LOGGER.info(String.format("Message sent -> %s", employeeToPostDto.toString()));
        rabbitTemplate.convertAndSend(exchange, routingKey, employeeToPostDto);
    }
}
