package com.dancing.stars.service;

import com.dancing.stars.entity.Episode;
import com.dancing.stars.exception.NotFoundException;
import com.dancing.stars.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EpisodeService {
    @Autowired
    private EpisodeRepository repository;

    public List<Episode> getAllEpisodes() {
        return repository.findAll();
    }

    public Episode getEpisodeByDate(Date date) {
        if (date == null) {
            throw new NullPointerException("No input data!");

        } else {
            Optional<Episode> result = repository.findById(date);

            if (result.isEmpty()) {
                throw new NotFoundException("No such data!");
            } else {
                return result.get();
            }
        }
    }
}
