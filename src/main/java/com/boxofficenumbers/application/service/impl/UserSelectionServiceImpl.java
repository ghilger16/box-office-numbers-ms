package com.boxofficenumbers.application.service.impl;

import com.boxofficenumbers.api.dto.MovieSelectionDto;
import com.boxofficenumbers.api.dto.UserMovieSelectionDto;
import com.boxofficenumbers.api.impl.UserSelectionSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSelectionServiceImpl {

    private final UserSelectionSheetRepository userSelectionSheetRepository;

    @Autowired
    public UserSelectionServiceImpl(UserSelectionSheetRepository userSelectionSheetRepository) {
        this.userSelectionSheetRepository = userSelectionSheetRepository;
    }

    public UserMovieSelectionDto getMovieSelectionsForUser(String userName) {
        List<UserMovieSelectionDto> selections = userSelectionSheetRepository.findByUserName(userName);
        if (!selections.isEmpty()) {
            return selections.get(0);
        }
        return null;
    }

    public UserMovieSelectionDto saveUserSelection(UserMovieSelectionDto userSelection) {
        // Retrieve the movieSelections list from the userSelection object
        List<MovieSelectionDto> movieSelections = userSelection.getMovieSelections();

        // Set the UserMovieSelectionDto object to the userMovieSelection property of each MovieSelectionDto object
        for (MovieSelectionDto movieSelection : movieSelections) {
            movieSelection.setUserMovieSelection(userSelection);
        }

        // Save the UserMovieSelectionDto object
        return userSelectionSheetRepository.save(userSelection);
    }
}