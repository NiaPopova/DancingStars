package com.dancing.stars.repository;

import com.dancing.stars.entity.Dance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DanceRepository extends JpaRepository<Dance, String> {
}
