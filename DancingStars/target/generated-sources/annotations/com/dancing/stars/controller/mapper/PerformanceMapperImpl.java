package com.dancing.stars.controller.mapper;

import com.dancing.stars.entity.Performance;
import com.dancing.stars.entity.Team;
import com.dancing.stars.entity.dto.PerformanceDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-03T14:00:53+0300",
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
        performanceDTO.setDance( entity.getDance() );
        performanceDTO.setEpisode( entity.getEpisode() );
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
}
