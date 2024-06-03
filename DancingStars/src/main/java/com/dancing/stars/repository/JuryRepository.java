package com.dancing.stars.repository;

import com.dancing.stars.entity.Jury;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JuryRepository extends JpaRepository<Jury, Integer> {

    Optional<Jury> findByNameContainingIgnoreCase(String name);
}
