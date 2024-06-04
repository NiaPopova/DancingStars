package com.dancing.stars.entity.dto;

import com.dancing.stars.entity.Team;
import lombok.Data;

@Data
public class UserDTO {
    private String email;
    private Team favouriteTeam;
}
