package com.example.rabbitmqapp.domain.service;

import com.example.rabbitmqapp.controller.dto.EmployeeDto;
import com.example.rabbitmqapp.controller.dto.EmployeeToPostDto;
import com.example.rabbitmqapp.domain.entity.Employee;
import com.example.rabbitmqapp.domain.repository.EmployeeRepository;
import com.example.rabbitmqapp.exception.NotFoundException;
import com.example.rabbitmqapp.mapper.EmployeeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


    public EmployeeDto findById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        Employee employee = employeeOptional.orElseThrow(NotFoundException::new);
        return employeeMapper.convertToDto(employee);
    }

    public List<EmployeeDto> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employeeMapper.convertListToDto(employees);
    }

    public EmployeeDto add(EmployeeToPostDto employeeToPostDto) {
        Employee employee = employeeMapper.convertToObject(employeeToPostDto);
        Employee persistedEmployee = employeeRepository.save(employee);
        return employeeMapper.convertToDto(persistedEmployee);
    }
}
