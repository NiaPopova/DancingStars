package com.dancing.stars.service;

import com.dancing.stars.entity.Performance;
import com.dancing.stars.entity.dto.JuryScoresSummaryDTO;
import com.dancing.stars.entity.dto.PerformanceDetailsDTO;
import com.dancing.stars.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PerformanceService {

    @Autowired
    private PerformanceRepository repository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<PerformanceDetailsDTO> getAllPerformanceDetails() {
        String sql = "SELECT * FROM PERFORMANCE_DETAILS";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PerformanceDetailsDTO.class));
    }

    public List<JuryScoresSummaryDTO> getAllJuryScoresSummary() {
        String sql = "SELECT * FROM JURY_SCORES_SUMMARY";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(JuryScoresSummaryDTO.class));
    }

    public List<Performance> getAllPerformances() {
        return repository.findAll();
    }

}
