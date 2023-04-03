package com.example.rabbitmqapp.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDto {
    private String uri;
    private String title;
    private String message;
}
