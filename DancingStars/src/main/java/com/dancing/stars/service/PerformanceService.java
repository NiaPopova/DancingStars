package com.dancing.stars.service;

import com.dancing.stars.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformanceService {
    @Autowired
    private PerformanceRepository repository;
}
