package com.example.rabbitmqapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RabbitmqAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqAppApplication.class, args);
    }
}
