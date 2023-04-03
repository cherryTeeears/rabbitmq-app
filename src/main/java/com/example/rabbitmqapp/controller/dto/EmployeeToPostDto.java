package com.example.rabbitmqapp.controller.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeToPostDto implements Serializable {

    private String name;
    private String email;
}
