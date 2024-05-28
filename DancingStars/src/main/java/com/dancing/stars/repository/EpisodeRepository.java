package com.dancing.stars.repository;

import com.dancing.stars.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface EpisodeRepository extends JpaRepository<Episode, Date> {
}
