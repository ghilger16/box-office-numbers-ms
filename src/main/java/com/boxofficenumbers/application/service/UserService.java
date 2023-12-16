package com.boxofficenumbers.application.service;

import com.boxofficenumbers.api.dto.ResponseDto;
import com.boxofficenumbers.api.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUserById(Long userId);

    ResponseDto createUser(UserDto userDto);

    ResponseDto updateUser(Long userId, UserDto updatedUserDto);

    ResponseDto deleteUser(Long userId);
}
