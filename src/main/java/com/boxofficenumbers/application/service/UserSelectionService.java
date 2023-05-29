package com.boxofficenumbers.application.service;


import com.boxofficenumbers.api.dto.UserMovieSelectionDto;

public interface UserSelectionService {
    UserMovieSelectionDto saveUserSelection(UserMovieSelectionDto userSelection);
}