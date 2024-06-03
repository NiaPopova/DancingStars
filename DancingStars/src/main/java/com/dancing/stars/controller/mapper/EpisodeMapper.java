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
    @Mapping(source = "winnerTeam.sms", target = "winnerTeamSMS")
    @Mapping(source = "secondWinnerTeam.sms", target = "secondWinnerTeamSMS")
    @Mapping(source = "thirdWinnerTeam.sms", target = "thirdWinnerTeamSMS")
    @Mapping(source = "losingTeam.sms", target = "losingTeamSMS")
    @Mapping(source = "secondLosingTeam.sms", target = "secondLosingTeamSMS")
    EpisodeDTO entityToDTO(Episode entity);
}
