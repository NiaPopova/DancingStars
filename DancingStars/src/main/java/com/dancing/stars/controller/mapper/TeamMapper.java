package com.dancing.stars.controller.mapper;

import com.dancing.stars.entity.Team;
import com.dancing.stars.entity.dto.TeamDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    @Mapping(source = "sms", target = "sms")
    @Mapping(source = "participantName", target = "participantName")
    @Mapping(source = "participantProfession", target = "participantProfession")
    @Mapping(source = "professionalName", target = "professionalName")
    @Mapping(source = "finalPosition", target = "finalPosition")
    @Mapping(source = "photo", target = "photo")
    TeamDTO entityToDTO(Team entity);
}
