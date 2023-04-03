package com.example.rabbitmqapp.domain.consumer;

import com.example.rabbitmqapp.controller.dto.EmployeeToPostDto;
import com.example.rabbitmqapp.domain.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RabbitConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitConsumer.class);
    private final EmployeeService employeeService;

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(EmployeeToPostDto employeeToPostDto) {
        LOGGER.info(String.format("Received message -> %s", employeeToPostDto.toString()));
        employeeService.add(employeeToPostDto);
    }
}
