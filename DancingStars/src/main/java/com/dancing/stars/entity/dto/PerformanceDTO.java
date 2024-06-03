package com.dancing.stars.entity.dto;

import com.dancing.stars.entity.Dance;
import com.dancing.stars.entity.Episode;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PerformanceDTO {
    private String teamSMS;
    private Integer scoreAudience;
    private Dance dance;
    private Episode episode;
    private String notes;
}
