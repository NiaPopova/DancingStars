package com.dancing.stars.controller;

import com.dancing.stars.controller.mapper.TeamMapper;
import com.dancing.stars.entity.Team;
import com.dancing.stars.entity.dto.TeamDTO;
import com.dancing.stars.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService service;
    @Autowired
    private TeamMapper mapper;

    @GetMapping
    public ResponseEntity<List<TeamDTO>> getAllTeams() {
        List<Team> result = service.getAllTeams();

        return ResponseEntity.ok(result.stream()
                .map(mapper::entityToDTO)
                .collect(Collectors.toList()));

    }

    @GetMapping("/team")
    public ResponseEntity<TeamDTO> getTeamByParticipantName(@RequestParam(name = "sms") String sms) {
        return ResponseEntity.ok(mapper.entityToDTO(service.getTeamByParticipantName(sms)));
    }
}
