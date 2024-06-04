package com.dancing.stars.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "USERS")
public class User {
    @Id
    @Column(name = "EMAIL", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "PASSWORD", length = 20)
    private String password;

    @ManyToOne
    @JoinColumn(name = "FAV_TEAM")
    private Team favouriteTeam;
}
