package com.boxofficenumbers.application.service;


import com.boxofficenumbers.api.dto.UserMovieSelectionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface UserSelectionSheetRepository extends JpaRepository<UserMovieSelectionDto, Long> {

    List<UserMovieSelectionDto> findByUserName(String userName);
    UserMovieSelectionDto save(UserMovieSelectionDto userMovieSelectionDto);
}
