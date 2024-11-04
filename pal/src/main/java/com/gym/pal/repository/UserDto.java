package com.gym.pal.repository;

import com.gym.pal.domain.UserDto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private List<UserDto> userdtos = new ArrayList<>();

    public List<UserDto> getAllSocio() {
        return userdtos;
    }

    public UserDto createUser(UserDto userdto) {
        userdtos.add(userdto);
        return userdto;
    }
}
