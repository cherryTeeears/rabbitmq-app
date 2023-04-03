package com.example.rabbitmqapp.controller.handler;

import com.example.rabbitmqapp.controller.dto.ExceptionDto;
import com.example.rabbitmqapp.exception.AbstractException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AbstractException.class)
    public ExceptionDto handleNotFoundException(HttpServletRequest request,
                                                HttpServletResponse response, AbstractException e) {
        response.setStatus(e.getStatus().value());
        return new ExceptionDto(request.getRequestURI(), e.getTitle(), e.getMessage());
    }
}
