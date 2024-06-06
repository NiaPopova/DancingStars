package com.dancing.stars.entity.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PerformanceDetailsDTO {
    private Integer performanceId;
    private String participantName;
    private String participantProfession;
    private String professionalName;
    private String danceName;
    private LocalDate episodeDate;
    private Integer audienceScore;
    private String notes;
    private String photo;
}

