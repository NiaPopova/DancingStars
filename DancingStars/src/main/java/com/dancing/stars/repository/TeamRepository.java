package com.dancing.stars.repository;

import com.dancing.stars.entity.Jury;
import com.dancing.stars.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, String> {
    Optional<Team> findByParticipantNameContainingIgnoreCase(String name);
}
