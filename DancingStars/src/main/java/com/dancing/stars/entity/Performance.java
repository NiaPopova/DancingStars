package com.dancing.stars.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "PERFORMANCES")
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;

    @Column(name = "SCORE-AUD")
    private Integer scoreAudience;

    @ManyToOne
    @JoinColumn(name = "TEAM_SMS")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "DANCE_NAME")
    private Dance dance;

    @ManyToOne
    @JoinColumn(name = "EP_DATE")
//    @Temporal(TemporalType.DATE)
    private Episode episode;

    @Column(name = "NOTES", length = 500)
    private String notes;

}
