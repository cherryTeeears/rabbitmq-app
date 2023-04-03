package com.example.rabbitmqapp.domain.repository;

import com.example.rabbitmqapp.domain.entity.EmployeeCacheData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CacheDataRepository extends CrudRepository<EmployeeCacheData, String> {
}
