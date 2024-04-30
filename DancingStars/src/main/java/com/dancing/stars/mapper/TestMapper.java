package com.dancing.stars.mapper;

import com.dancing.stars.entitty.Test;
import com.dancing.stars.mapper.dto.TestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface TestMapper {
    @Mapping(target = "str", source = "str")
    TestDto mapToDto(Test test);
}
