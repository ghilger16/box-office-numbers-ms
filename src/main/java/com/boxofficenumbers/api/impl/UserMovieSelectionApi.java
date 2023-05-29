package com.boxofficenumbers.api.impl;

import com.boxofficenumbers.api.dto.UserMovieSelectionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserMovieSelectionApi {

    @GetMapping("/users/{userName}/movie-selections")
    ResponseEntity<UserMovieSelectionDto> getMovieSelectionsForUser(@PathVariable String userName);

    @PostMapping("/userSelections")
    ResponseEntity<UserMovieSelectionDto> addUserSelection(@RequestBody UserMovieSelectionDto userSelection);
}
