package com.dancing.stars.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "DANCES")
public class Dance {

    @Id
    @Column(name = "NAME", nullable = false, unique = true, length = 50)
    private String name;

    @Column(name = "DESCR", length = 500)
    private String description;

    @Column(name = "PHOTO", length = 500)
    private String photo;
}
