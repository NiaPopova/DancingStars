package com.dancing.stars.controller.mapper;

import com.dancing.stars.entity.Episode;
import com.dancing.stars.entity.dto.EpisodeDTO;
import com.dancing.stars.entity.dto.JuryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EpisodeMapper {
    @Mapping(source = "date", target = "date")
    @Mapping(source = "theme", target = "theme")
    @Mapping(source = "winnerTeam", target = "winnerTeam")
    @Mapping(source = "secondWinnerTeam", target = "secondWinnerTeam")
    @Mapping(source = "thirdWinnerTeam", target = "thirdWinnerTeam")
    @Mapping(source = "losingTeam", target = "losingTeam")
    @Mapping(source = "secondLosingTeam", target = "secondLosingTeam")
    EpisodeDTO entityToDTO(Episode entity);
}
