package com.dancing.stars.controller;

import com.dancing.stars.controller.mapper.EpisodeMapper;
import com.dancing.stars.entity.Episode;
import com.dancing.stars.entity.dto.EpisodeDTO;
import com.dancing.stars.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {

    @Autowired
    private EpisodeService service;
    @Autowired
    private EpisodeMapper mapper;

    @GetMapping
    public ResponseEntity<List<EpisodeDTO>> getAllEpisodes() {
        List<Episode> result = service.getAllEpisodes();

        return ResponseEntity.ok(result.stream()
                .map(mapper::entityToDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/episode")
    public ResponseEntity<EpisodeDTO> getEpisodeByDate(@RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return ResponseEntity.ok(mapper.entityToDTO(service.getEpisodeByDate(date)));
    }
}
