package com.dancing.stars.controller.mapper;

import com.dancing.stars.entity.Dance;
import com.dancing.stars.entity.dto.DanceDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-04T16:48:58+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class DanceMapperImpl implements DanceMapper {

    @Override
    public DanceDTO entityToDTO(Dance entity) {
        if ( entity == null ) {
            return null;
        }

        DanceDTO danceDTO = new DanceDTO();

        danceDTO.setName( entity.getName() );
        danceDTO.setDescription( entity.getDescription() );

        return danceDTO;
    }
}
