package com.dancing.stars.controller;

import com.dancing.stars.controller.mapper.DanceMapper;
import com.dancing.stars.entity.Dance;
import com.dancing.stars.entity.dto.DanceDTO;
import com.dancing.stars.service.DanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dances")
public class DanceController {

    @Autowired
    private DanceService service;
    @Autowired
    private DanceMapper mapper;

    @GetMapping
    public ResponseEntity<List<DanceDTO>> getAllDances() {
        List<Dance> result = service.getAllDances();

        return ResponseEntity.ok(result.stream()
                .map(mapper::entityToDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/dance")
    public ResponseEntity<DanceDTO> getDanceByName(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(mapper.entityToDTO
                (service.getDanceByName(name)));
    }

}
