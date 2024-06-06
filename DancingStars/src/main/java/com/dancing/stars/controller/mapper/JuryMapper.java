package com.dancing.stars.controller.mapper;

import com.dancing.stars.entity.Jury;
import com.dancing.stars.entity.dto.JuryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JuryMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "profession", target = "profession")
    @Mapping(source = "photo", target = "photo")
    JuryDTO entityToDTO(Jury entity);

}
