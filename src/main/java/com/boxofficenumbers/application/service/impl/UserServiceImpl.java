package com.boxofficenumbers.application.service.impl;

import com.boxofficenumbers.api.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean authenticate(String username, String password) {
        // Find the user by username
        UserDto user = userRepository.findById(username).orElse(null);

        // Check if the user exists and the password matches
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return true; // Authentication successful
        }

        return false; // Authentication failed
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserDto> getUserById(String userName) {
        return userRepository.findById(userName);
    }

    public UserDto createUser(UserDto user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);

    }

    public UserDto updateUser(UserDto user) {
        return userRepository.save(user);
    }

    public void deleteUser(String userName) {
        userRepository.deleteById(userName);
    }
}
