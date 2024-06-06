package com.dancing.stars.controller.mapper;

import com.dancing.stars.entity.Dance;
import com.dancing.stars.entity.Episode;
import com.dancing.stars.entity.Performance;
import com.dancing.stars.entity.Team;
import com.dancing.stars.entity.dto.DanceDTO;
import com.dancing.stars.entity.dto.EpisodeDTO;
import com.dancing.stars.entity.dto.PerformanceDTO;
import com.dancing.stars.entity.dto.TeamDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-06T19:58:51+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PerformanceMapperImpl implements PerformanceMapper {

    @Override
    public PerformanceDTO entityToDTO(Performance entity) {
        if ( entity == null ) {
            return null;
        }

        PerformanceDTO performanceDTO = new PerformanceDTO();

        performanceDTO.setTeamSMS( entityTeamSms( entity ) );
        performanceDTO.setScoreAudience( entity.getScoreAudience() );
        performanceDTO.setDance( danceToDanceDTO( entity.getDance() ) );
        performanceDTO.setEpisode( episodeToEpisodeDTO( entity.getEpisode() ) );
        performanceDTO.setNotes( entity.getNotes() );

        return performanceDTO;
    }

    private String entityTeamSms(Performance performance) {
        if ( performance == null ) {
            return null;
        }
        Team team = performance.getTeam();
        if ( team == null ) {
            return null;
        }
        String sms = team.getSms();
        if ( sms == null ) {
            return null;
        }
        return sms;
    }

    protected DanceDTO danceToDanceDTO(Dance dance) {
        if ( dance == null ) {
            return null;
        }

        DanceDTO danceDTO = new DanceDTO();

        danceDTO.setName( dance.getName() );
        danceDTO.setDescription( dance.getDescription() );

        return danceDTO;
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

    protected EpisodeDTO episodeToEpisodeDTO(Episode episode) {
        if ( episode == null ) {
            return null;
        }

        EpisodeDTO episodeDTO = new EpisodeDTO();

        episodeDTO.setDate( episode.getDate() );
        episodeDTO.setTheme( episode.getTheme() );
        episodeDTO.setWinnerTeam( teamToTeamDTO( episode.getWinnerTeam() ) );
        episodeDTO.setSecondWinnerTeam( teamToTeamDTO( episode.getSecondWinnerTeam() ) );
        episodeDTO.setThirdWinnerTeam( teamToTeamDTO( episode.getThirdWinnerTeam() ) );
        episodeDTO.setLosingTeam( teamToTeamDTO( episode.getLosingTeam() ) );
        episodeDTO.setSecondLosingTeam( teamToTeamDTO( episode.getSecondLosingTeam() ) );

        return episodeDTO;
    }
}
