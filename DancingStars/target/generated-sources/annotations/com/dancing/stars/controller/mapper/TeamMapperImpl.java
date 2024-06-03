package com.dancing.stars.controller.mapper;

import com.dancing.stars.entity.Team;
import com.dancing.stars.entity.dto.TeamDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-03T14:00:52+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TeamMapperImpl implements TeamMapper {

    @Override
    public TeamDTO entityToDTO(Team entity) {
        if ( entity == null ) {
            return null;
        }

        TeamDTO teamDTO = new TeamDTO();

        teamDTO.setSms( entity.getSms() );
        teamDTO.setParticipantName( entity.getParticipantName() );
        teamDTO.setParticipantProfession( entity.getParticipantProfession() );
        teamDTO.setProfessionalName( entity.getProfessionalName() );
        teamDTO.setFinalPosition( entity.getFinalPosition() );

        return teamDTO;
    }
}
