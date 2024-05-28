package com.dancing.stars.repository;

import com.dancing.stars.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<Performance, Integer> {
}
