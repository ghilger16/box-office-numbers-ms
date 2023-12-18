package com.boxofficenumbers.application.service.impl;

import com.boxofficenumbers.api.dto.ResponseDto;
import com.boxofficenumbers.api.dto.UserDto;
import com.boxofficenumbers.adapter.UserRepository;
import com.boxofficenumbers.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDto getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public ResponseDto createUser(UserDto userDto) {
        userRepository.save(userDto);

        ResponseDto response = new ResponseDto();
        response.setId(userDto.getId().intValue());
        response.setMessage("Movie created successfully");
        response.setHasError(false);

        return response;
    }

    @Override
    public ResponseDto updateUser(Long userId, UserDto updatedUserDto) {
        if (userRepository.existsById(userId)) {
            updatedUserDto.setId(userId);
            userRepository.save(updatedUserDto);

            ResponseDto response = new ResponseDto();
            response.setId(updatedUserDto.getId().intValue());
            response.setMessage("User updated successfully");
           response.setHasError(false);

           return response;
        } else {
           ResponseDto response = new ResponseDto();
           response.setId(0);
           response.setMessage("User update failed");
           response.setHasError(true);

           return response;
        }
    }

    @Override
    public ResponseDto deleteUser(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);

            ResponseDto response = new ResponseDto();
            response.setId(userId.intValue());
            response.setMessage("User deleted successfully");
            response.setHasError(false);

            return response;
        } else {
            ResponseDto response = new ResponseDto();
            response.setId(0);
            response.setMessage("User delete failed");
            response.setHasError(true);

            return response;
        }
    }
}
