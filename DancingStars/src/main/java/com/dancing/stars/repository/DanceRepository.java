package com.dancing.stars.repository;

import com.dancing.stars.entity.Dance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DanceRepository extends JpaRepository<Dance, String> {

    Optional<Dance> findByNameContainingIgnoreCase(String name);
}
