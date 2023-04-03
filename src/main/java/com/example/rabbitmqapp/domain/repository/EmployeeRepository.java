package com.example.rabbitmqapp.domain.repository;

import com.example.rabbitmqapp.domain.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findAll();
}
