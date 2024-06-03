package com.dancing.stars.service;

import com.dancing.stars.entity.Performance;
import com.dancing.stars.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PerformanceService {

    @Autowired
    private PerformanceRepository repository;

    public List<Performance> getAllPerformances() {
        return repository.findAll();
    }

}
