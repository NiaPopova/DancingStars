package com.dancing.stars.controller;

import com.dancing.stars.controller.mapper.DanceMapper;
import com.dancing.stars.entity.Dance;
import com.dancing.stars.service.DanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dances")
public class DanceController {

    @Autowired
    private DanceService service;
    @Autowired
    private DanceMapper mapper;

    @GetMapping
    public ResponseEntity<List<Dance>> getAllDances() {
        return ResponseEntity.ok(service.getAllDances());

    }

    @GetMapping("/dance")
    public ResponseEntity<Dance> getDanceByName(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(service.getDanceByName(name));
    }

}
