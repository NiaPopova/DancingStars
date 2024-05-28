package com.dancing.stars.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
class JuryScoreId implements Serializable {
    private Integer performanceId;
    private Integer juryId;

}
