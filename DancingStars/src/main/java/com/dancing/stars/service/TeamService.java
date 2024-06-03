package com.dancing.stars.service;

import com.dancing.stars.entity.Team;
import com.dancing.stars.exception.NotFoundException;
import com.dancing.stars.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository repository;

    public List<Team> getAllTeams() {
        return repository.findAll();
    }

    public Team getTeamByParticipantName(String name) {
        if (name == null) {
            throw new NullPointerException("No input data!");

        } else {
            Optional<Team> result = repository.findByParticipantNameContainingIgnoreCase(name);

            if (result.isEmpty()) {
                throw new NotFoundException("No such data!");
            } else {
                return result.get();
            }
        }
    }
}
