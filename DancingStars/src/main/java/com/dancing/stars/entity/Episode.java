package com.dancing.stars.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "EPISODES")
public class Episode {

    @Id
    @Column(name = "DATE", nullable = false, unique = true)
    private LocalDate date;

    @Column(name = "THEME", length = 100)
    private String theme;

    @ManyToOne
    @JoinColumn(name = "WT_SMS")
    private Team winnerTeam;

    @ManyToOne
    @JoinColumn(name = "SWT_SMS")
    private Team secondWinnerTeam;

    @ManyToOne
    @JoinColumn(name = "THWT_SMS")
    private Team thirdWinnerTeam;

    @ManyToOne
    @JoinColumn(name = "LT_SMS")
    private Team losingTeam;

    @ManyToOne
    @JoinColumn(name = "SLT_SMS")
    private Team secondLosingTeam;


}
