package com.dancing.stars.service;

import com.dancing.stars.entitty.Test;
import com.dancing.stars.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//This is a test class to check the connection
// from the db from e specific schema
@Service
public class TestService {

    @Autowired
    private TestRepository repository;

    public String getRepositoryByStr(String str) {
        if (str != null) {
            Optional<Test> result = repository.findByStr(str);

            return result.map(Test::getStr).orElse(null);
        }
        return null;
    }
}
