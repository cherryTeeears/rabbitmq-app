package com.example.rabbitmqapp.controller.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class EmployeeDto implements Serializable {

    private Long id;
    private String name;
    private String email;
}
