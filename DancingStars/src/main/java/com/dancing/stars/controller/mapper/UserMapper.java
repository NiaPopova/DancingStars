package com.dancing.stars.controller.mapper;

import com.dancing.stars.entity.User;
import com.dancing.stars.entity.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "email", target = "email")
    @Mapping(source = "favouriteTeam", target = "favouriteTeam")
    UserDTO entityToDTO(User user);
}
