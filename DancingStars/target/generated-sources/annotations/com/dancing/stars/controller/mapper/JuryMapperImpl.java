package com.dancing.stars.controller.mapper;

import com.dancing.stars.entity.Jury;
import com.dancing.stars.entity.dto.JuryDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-06T22:41:19+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class JuryMapperImpl implements JuryMapper {

    @Override
    public JuryDTO entityToDTO(Jury entity) {
        if ( entity == null ) {
            return null;
        }

        JuryDTO juryDTO = new JuryDTO();

        juryDTO.setName( entity.getName() );
        juryDTO.setProfession( entity.getProfession() );
        juryDTO.setPhoto( entity.getPhoto() );

        return juryDTO;
    }
}
