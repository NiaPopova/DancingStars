package com.dancing.stars.service;

import com.dancing.stars.entity.Jury;
import com.dancing.stars.exception.NotFoundException;
import com.dancing.stars.repository.JuryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JuryService {

    @Autowired
    private JuryRepository repository;

    public List<Jury> getAllJury() {
        return repository.findAll();
    }

    public Jury getJuryByName(String name) {
        if (name == null) {
            throw new NullPointerException("No input data!");

        } else {
            Optional<Jury> result = repository.findByNameContainingIgnoreCase(name);

            if (result.isEmpty()) {
                throw new NotFoundException("No such data!");
            } else {
                return result.get();
            }
        }

    }
}
