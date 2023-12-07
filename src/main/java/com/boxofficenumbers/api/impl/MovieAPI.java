package com.boxofficenumbers.api.impl;

import com.boxofficenumbers.api.dto.MovieDto;
import com.boxofficenumbers.api.dto.ResponseDto;

import java.util.List;

public interface MovieAPI {
    List<MovieDto> getAllMovies();

    MovieDto getMovieById(long movieId);

    ResponseDto createMovie(MovieDto movieDto);

    ResponseDto updateMovie(long movieId, MovieDto movieDto);

    ResponseDto deleteMovie(long movieId);


}
