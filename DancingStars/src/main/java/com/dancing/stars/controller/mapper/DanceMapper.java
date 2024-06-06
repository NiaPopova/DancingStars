package com.dancing.stars.controller.mapper;

import com.dancing.stars.entity.Dance;
import com.dancing.stars.entity.dto.DanceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DanceMapper {
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "photo", target = "photo")
    DanceDTO entityToDTO(Dance entity);

}
