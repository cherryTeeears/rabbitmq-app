package com.example.rabbitmqapp.controller;

import com.example.rabbitmqapp.controller.dto.EmployeeToPostDto;
import com.example.rabbitmqapp.domain.service.EmployeeService;
import com.example.rabbitmqapp.controller.dto.EmployeeDto;
import com.example.rabbitmqapp.domain.producer.RabbitProducer;
import com.example.rabbitmqapp.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final RabbitProducer rabbitProducer;

    @GetMapping
    public List<EmployeeDto> getList() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeDto getById(@PathVariable("id") Long id) throws NotFoundException {
        return employeeService.findById(id);
    }

    @PostMapping
    public EmployeeToPostDto sendMessage(@RequestBody EmployeeToPostDto employeeToPostDto) {
        rabbitProducer.sendMessage(employeeToPostDto);
        return employeeToPostDto;
    }
}
