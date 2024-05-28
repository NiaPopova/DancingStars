package com.dancing.stars.service;

import com.dancing.stars.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpisodeService {
    @Autowired
    private EpisodeRepository repository;
}
