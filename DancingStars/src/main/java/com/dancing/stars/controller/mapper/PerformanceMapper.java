package com.dancing.stars.controller.mapper;

import com.dancing.stars.entity.Performance;
import com.dancing.stars.entity.dto.PerformanceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PerformanceMapper {
    @Mapping(source = "team.sms", target = "teamSMS")
    @Mapping(source = "scoreAudience", target = "scoreAudience")
    @Mapping(source = "dance", target = "dance")
    @Mapping(source = "episode", target = "episode")
    @Mapping(source = "notes", target = "notes")
    PerformanceDTO entityToDTO(Performance entity);
}
