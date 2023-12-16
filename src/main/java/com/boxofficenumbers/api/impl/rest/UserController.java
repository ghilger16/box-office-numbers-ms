package com.boxofficenumbers.api.impl.rest;

import com.boxofficenumbers.api.dto.ResponseDto;
import com.boxofficenumbers.api.dto.UserDto;
import com.boxofficenumbers.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public ResponseDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping("/{userId}")
    public ResponseDto updateUser(@PathVariable Long userId, @RequestBody UserDto updatedUserDto) {
        return userService.updateUser(userId, updatedUserDto);
    }

    @DeleteMapping("/{userId}")
    public ResponseDto deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
}
