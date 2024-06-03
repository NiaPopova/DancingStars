package com.dancing.stars.controller.mapper;

import com.dancing.stars.entity.Episode;
import com.dancing.stars.entity.Team;
import com.dancing.stars.entity.dto.EpisodeDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-03T14:00:53+0300",
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
        episodeDTO.setWinnerTeamSMS( entityWinnerTeamSms( entity ) );
        episodeDTO.setSecondWinnerTeamSMS( entitySecondWinnerTeamSms( entity ) );
        episodeDTO.setThirdWinnerTeamSMS( entityThirdWinnerTeamSms( entity ) );
        episodeDTO.setLosingTeamSMS( entityLosingTeamSms( entity ) );
        episodeDTO.setSecondLosingTeamSMS( entitySecondLosingTeamSms( entity ) );

        return episodeDTO;
    }

    private String entityWinnerTeamSms(Episode episode) {
        if ( episode == null ) {
            return null;
        }
        Team winnerTeam = episode.getWinnerTeam();
        if ( winnerTeam == null ) {
            return null;
        }
        String sms = winnerTeam.getSms();
        if ( sms == null ) {
            return null;
        }
        return sms;
    }

    private String entitySecondWinnerTeamSms(Episode episode) {
        if ( episode == null ) {
            return null;
        }
        Team secondWinnerTeam = episode.getSecondWinnerTeam();
        if ( secondWinnerTeam == null ) {
            return null;
        }
        String sms = secondWinnerTeam.getSms();
        if ( sms == null ) {
            return null;
        }
        return sms;
    }

    private String entityThirdWinnerTeamSms(Episode episode) {
        if ( episode == null ) {
            return null;
        }
        Team thirdWinnerTeam = episode.getThirdWinnerTeam();
        if ( thirdWinnerTeam == null ) {
            return null;
        }
        String sms = thirdWinnerTeam.getSms();
        if ( sms == null ) {
            return null;
        }
        return sms;
    }

    private String entityLosingTeamSms(Episode episode) {
        if ( episode == null ) {
            return null;
        }
        Team losingTeam = episode.getLosingTeam();
        if ( losingTeam == null ) {
            return null;
        }
        String sms = losingTeam.getSms();
        if ( sms == null ) {
            return null;
        }
        return sms;
    }

    private String entitySecondLosingTeamSms(Episode episode) {
        if ( episode == null ) {
            return null;
        }
        Team secondLosingTeam = episode.getSecondLosingTeam();
        if ( secondLosingTeam == null ) {
            return null;
        }
        String sms = secondLosingTeam.getSms();
        if ( sms == null ) {
            return null;
        }
        return sms;
    }
}
