package com.example.rabbitmqapp.mapper;

import com.example.rabbitmqapp.controller.dto.EmployeeToPostDto;
import com.example.rabbitmqapp.domain.entity.Employee;
import com.example.rabbitmqapp.controller.dto.EmployeeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    public EmployeeDto convertToDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setEmail(employee.getEmail());
        return employeeDto;
    }

    public Employee convertToObject(EmployeeDto employeeDto){
        Employee employee = new Employee();

        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        return employee;
    }
    public Employee convertToObject(EmployeeToPostDto employeeToPostDto){
        Employee employee = new Employee();

        employee.setName(employeeToPostDto.getName());
        employee.setEmail(employeeToPostDto.getEmail());
        return employee;
    }

    public List<EmployeeDto> convertListToDto(List<Employee> employees) {
        return employees.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
