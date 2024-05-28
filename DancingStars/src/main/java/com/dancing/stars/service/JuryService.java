package com.dancing.stars.service;

import com.dancing.stars.repository.JuryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JuryService {
    @Autowired
    private JuryRepository repository;
}
