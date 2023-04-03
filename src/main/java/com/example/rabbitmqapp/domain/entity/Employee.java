package com.example.rabbitmqapp.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="employee")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}
