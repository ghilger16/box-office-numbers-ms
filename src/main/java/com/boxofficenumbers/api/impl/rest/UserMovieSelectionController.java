package com.boxofficenumbers.api.impl.rest;

import com.boxofficenumbers.api.dto.UserMovieSelectionDto;
import com.boxofficenumbers.api.impl.UserMovieSelectionApi;
import com.boxofficenumbers.application.service.impl.UserSelectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserMovieSelectionController implements UserMovieSelectionApi {

    private final UserSelectionServiceImpl userSelectionServiceImpl;

    @Autowired
    public UserMovieSelectionController(UserSelectionServiceImpl userSelectionServiceImpl) {
        this.userSelectionServiceImpl = userSelectionServiceImpl;
    }
    @GetMapping("/users/{userName}/movie-selections")
    public ResponseEntity<UserMovieSelectionDto> getMovieSelectionsForUser(@PathVariable String userName) {
        UserMovieSelectionDto movieSelection = userSelectionServiceImpl.getMovieSelectionsForUser(userName);

        if (movieSelection == null) {
            movieSelection = new UserMovieSelectionDto(); // Create an empty UserMovieSelectionDto object
        }

        return new ResponseEntity<>(movieSelection, HttpStatus.OK);
    }

    @PostMapping("/userSelections")
    public ResponseEntity<UserMovieSelectionDto> addUserSelection(@RequestBody UserMovieSelectionDto userSelection) {
        UserMovieSelectionDto savedUserSelection = userSelectionServiceImpl.saveUserSelection(userSelection);
        return new ResponseEntity<>(savedUserSelection, HttpStatus.CREATED);
    }
}
