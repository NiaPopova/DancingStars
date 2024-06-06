package com.dancing.stars.entity.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class EpisodeDTO {
    private LocalDate date;
    private String theme;
    private TeamDTO winnerTeam;
    private TeamDTO secondWinnerTeam;
    private TeamDTO thirdWinnerTeam;
    private TeamDTO losingTeam;
    private TeamDTO secondLosingTeam;
}
