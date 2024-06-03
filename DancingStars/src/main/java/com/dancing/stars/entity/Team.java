package com.dancing.stars.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "TEAMS")
public class Team {

    @Id
    @Column(name = "SMS", nullable = false, unique = true, length = 5)
    private String sms;

    @Column(name = "PART_NAME", length = 100)
    private String participantName;

    @Column(name = "PART_PROF", length = 100)
    private String participantProfession;

    @Column(name = "PROF_NAME", length = 100)
    private String professionalName;

    @Column(name = "FINAL_POS")
    private Integer finalPosition;

}
