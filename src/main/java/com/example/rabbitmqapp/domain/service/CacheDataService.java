package com.example.rabbitmqapp.domain.service;

import com.example.rabbitmqapp.domain.entity.EmployeeCacheData;
import com.example.rabbitmqapp.domain.repository.CacheDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CacheDataService {

    private final CacheDataRepository cacheDataRepository;

    public Optional<EmployeeCacheData> findById(String id){
        return cacheDataRepository.findById(id);
    }

    public void save(EmployeeCacheData employeeCacheData){
        cacheDataRepository.save(employeeCacheData);
    }
}
