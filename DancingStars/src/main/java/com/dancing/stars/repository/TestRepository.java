package com.dancing.stars.repository;

import com.dancing.stars.entitty.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//This is a test class to check the connection
// from the db from e specific schema
@Repository
public interface TestRepository extends JpaRepository<Test,Integer> {

    Optional<Test> findByStr(String str);
}
