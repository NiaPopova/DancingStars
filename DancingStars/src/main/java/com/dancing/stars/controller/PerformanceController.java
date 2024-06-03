package com.dancing.stars.controller;

import com.dancing.stars.controller.mapper.PerformanceMapper;
import com.dancing.stars.entity.Performance;
import com.dancing.stars.entity.dto.PerformanceDTO;
import com.dancing.stars.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/performances")
public class PerformanceController {

    @Autowired
    private PerformanceService service;
    @Autowired
    private PerformanceMapper mapper;

    @GetMapping
    public ResponseEntity<List<PerformanceDTO>> getAllPerformances() {
        List<Performance> result = service.getAllPerformances();
        return ResponseEntity.ok(result.stream()
                .map(mapper::entityToDTO)
                .collect(Collectors.toList()));
    }


    @GetMapping("/performance")
    public ResponseEntity<PerformanceDTO> getPerformance(){
        return null;//what?? todo
    }
}
