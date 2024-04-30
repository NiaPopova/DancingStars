package com.dancing.stars.controller;

import com.dancing.stars.mapper.TestMapper;
import com.dancing.stars.mapper.dto.TestDto;
import com.dancing.stars.entitty.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    //Todo
    //private TestMapper mapper;


    @GetMapping("/test")
    public ResponseEntity<Test> getTest() {
        Test test = new Test();
        test.setId(1);
        test.setStr("str");

        return ResponseEntity.ok(test);
    }

}
