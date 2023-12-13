package com.boxofficenumbers.application.service;

import com.boxofficenumbers.api.dto.MovieDto;
import com.boxofficenumbers.api.dto.ResponseDto;

import java.util.List;

public interface MovieService {

    List<MovieDto> getAllMovies();

    MovieDto getMovieById(Long movieId);

    List<MovieDto> getMoviesByIds(List<Long> ids);

    ResponseDto createMovie(MovieDto movieDto);

    ResponseDto updateMovie(Long movieId, MovieDto updatedMovieDto);

    ResponseDto deleteMovie(Long movieId);
}