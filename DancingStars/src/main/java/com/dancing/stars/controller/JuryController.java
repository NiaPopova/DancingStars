package com.dancing.stars.controller;

import com.dancing.stars.service.JuryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JuryController {
    @Autowired
    private JuryService service;
}
