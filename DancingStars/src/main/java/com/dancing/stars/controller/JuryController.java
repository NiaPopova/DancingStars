package com.dancing.stars.controller;

import com.dancing.stars.entity.Jury;
import com.dancing.stars.entity.dto.JuryDTO;
import com.dancing.stars.controller.mapper.JuryMapper;
import com.dancing.stars.service.JuryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jury")
public class JuryController {

    @Autowired
    private JuryService service;
    @Autowired
    private JuryMapper mapper;

    @GetMapping
    public ResponseEntity<List<JuryDTO>> getAllJury() {
        List<Jury> result = service.getAllJury();

        return ResponseEntity.ok(result.stream()
                .map(mapper::entityToDTO)
                .collect(Collectors.toList()));

    }

    @GetMapping("/jury")
    public ResponseEntity<JuryDTO> getJuryByName(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(mapper.entityToDTO(service.getJuryByName(name)));
    }

}
