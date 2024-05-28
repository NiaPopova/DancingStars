package com.dancing.stars.controller;

import com.dancing.stars.service.DanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DanceController {
    @Autowired
    private DanceService service;
}
