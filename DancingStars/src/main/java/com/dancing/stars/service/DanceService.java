package com.dancing.stars.service;

import com.dancing.stars.entity.Dance;
import com.dancing.stars.exception.NotFoundException;
import com.dancing.stars.repository.DanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DanceService {
    @Autowired
    private DanceRepository repository;

    public List<Dance> getAllDances() {
        return repository.findAll();
    }

    public Dance getDanceByName(String name) {
        if (name == null) {
            throw new NullPointerException("No input data!");//todo

        } else {
            Optional<Dance> result = repository.findByNameContainingIgnoreCase(name);

            if (result.isEmpty()) {
                throw new NotFoundException("No such data!");
            } else {
                return result.get();
            }
        }
    }
}
