package com.dancing.stars.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "JURY_SCORE")
public class JuryScore {

    @EmbeddedId
    private JuryScoreId id;

    @Column(name = "SCORE", nullable = false)
    private Integer score;

    @ManyToOne
    @MapsId("performanceId")
    @JoinColumn(name = "PERFORMANCE_ID")
    private Performance performance;

    @ManyToOne
    @MapsId("juryId")
    @JoinColumn(name = "JURY_ID")
    private Jury jury;

}
