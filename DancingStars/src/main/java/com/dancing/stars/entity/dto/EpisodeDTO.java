package com.dancing.stars.entity.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class EpisodeDTO {
    private LocalDate date;
    private String theme;
    private String winnerTeamSMS;
    private String secondWinnerTeamSMS;
    private String thirdWinnerTeamSMS;
    private String losingTeamSMS;
    private String secondLosingTeamSMS;
}
