package com.dancing.stars.controller;

import com.dancing.stars.entity.Team;
import com.dancing.stars.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService service;

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        return ResponseEntity.ok(service.getAllTeams());

    }

    @GetMapping("/team")
    public ResponseEntity<Team> getTeamByParticipantName(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(service.getTeamByParticipantName(name));
    }
}
