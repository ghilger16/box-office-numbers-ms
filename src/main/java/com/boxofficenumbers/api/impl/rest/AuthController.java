package com.boxofficenumbers.api.impl.rest;

import com.boxofficenumbers.api.dto.LoginRequestDto;
import com.boxofficenumbers.api.dto.LoginResponseDto;
import com.boxofficenumbers.api.dto.UserDto;
import com.boxofficenumbers.application.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public AuthController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequest) {
        System.out.println("Received LoginRequestDto: " + loginRequest);
        System.out.println("Username: " + loginRequest.getUserName());
        System.out.println("Password: " + loginRequest.getPassword());
        String username = loginRequest.getUserName();
        String password = loginRequest.getPassword();

        // Perform authentication using UserService
        boolean isAuthenticated = userServiceImpl.authenticate(username, password);

        if (isAuthenticated) {
            // Return success response with a token or other necessary data
            String token = generateAuthToken(username);
            LoginResponseDto responseDto = new LoginResponseDto(username, token);
            return ResponseEntity.ok(responseDto);
        } else {
            // Return unauthorized response
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = userServiceImpl.createUser(userDto);
        return ResponseEntity.ok(createdUser);
    }

    // Generate authentication token (example implementation)
    private String generateAuthToken(String username) {
        // Implementation for generating the authentication token
        // This is just an example and should be replaced with your own logic
        return "dummyAuthToken";
    }
}