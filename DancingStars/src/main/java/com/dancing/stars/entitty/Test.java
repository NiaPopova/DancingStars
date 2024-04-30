package com.dancing.stars.entitty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//This is a test class to check the connection
// from the db from e specific schema
@Entity
@Setter
@Getter
public class Test {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TESTSTR")
    private String str;

}
