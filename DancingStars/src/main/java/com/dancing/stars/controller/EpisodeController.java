package com.dancing.stars.controller;

import com.dancing.stars.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EpisodeController {
    @Autowired
    private EpisodeService service;
}
