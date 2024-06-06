package com.dancing.stars.controller.mapper;

import com.dancing.stars.entity.Episode;
import com.dancing.stars.entity.Team;
import com.dancing.stars.entity.dto.EpisodeDTO;
import com.dancing.stars.entity.dto.TeamDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-06T19:58:52+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class EpisodeMapperImpl implements EpisodeMapper {

    @Override
    public EpisodeDTO entityToDTO(Episode entity) {
        if ( entity == null ) {
            return null;
        }

        EpisodeDTO episodeDTO = new EpisodeDTO();

        episodeDTO.setDate( entity.getDate() );
        episodeDTO.setTheme( entity.getTheme() );
        episodeDTO.setWinnerTeam( teamToTeamDTO( entity.getWinnerTeam() ) );
        episodeDTO.setSecondWinnerTeam( teamToTeamDTO( entity.getSecondWinnerTeam() ) );
        episodeDTO.setThirdWinnerTeam( teamToTeamDTO( entity.getThirdWinnerTeam() ) );
        episodeDTO.setLosingTeam( teamToTeamDTO( entity.getLosingTeam() ) );
        episodeDTO.setSecondLosingTeam( teamToTeamDTO( entity.getSecondLosingTeam() ) );

        return episodeDTO;
    }

    protected TeamDTO teamToTeamDTO(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamDTO teamDTO = new TeamDTO();

        teamDTO.setSms( team.getSms() );
        teamDTO.setParticipantName( team.getParticipantName() );
        teamDTO.setParticipantProfession( team.getParticipantProfession() );
        teamDTO.setProfessionalName( team.getProfessionalName() );
        teamDTO.setFinalPosition( team.getFinalPosition() );

        return teamDTO;
    }
}
