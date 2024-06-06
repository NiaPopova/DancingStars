package com.dancing.stars.entity.dto;

import lombok.Data;

@Data
public class JuryScoresSummaryDTO {
    private Integer performanceId;
    private String teamSms;
    private Double averageJuryScore;
    private Integer juryCount;
}
