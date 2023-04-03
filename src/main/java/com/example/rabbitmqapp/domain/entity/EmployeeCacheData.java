package com.example.rabbitmqapp.domain.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;


@RedisHash("Employee")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class EmployeeCacheData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key;
    private String value;
}
