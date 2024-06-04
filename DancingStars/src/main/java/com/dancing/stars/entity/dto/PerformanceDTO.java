package com.dancing.stars.entity.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PerformanceDTO {
    private String teamSMS;
    private Integer scoreAudience;
    private DanceDTO dance;
    private EpisodeDTO episode;
    private String notes;
}
