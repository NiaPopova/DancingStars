package com.dancing.stars.service;

import com.dancing.stars.repository.DanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DanceService {
    @Autowired
    private DanceRepository repository;
}
