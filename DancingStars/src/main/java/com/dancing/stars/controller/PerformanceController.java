package com.dancing.stars.controller;

import com.dancing.stars.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerformanceController {
    @Autowired
    private PerformanceService service;
}
