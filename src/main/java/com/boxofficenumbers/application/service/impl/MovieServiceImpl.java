package com.boxofficenumbers.application.service.impl;

import com.boxofficenumbers.api.dto.MovieDto;
import com.boxofficenumbers.api.dto.ResponseDto;
import com.boxofficenumbers.application.service.MovieService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public abstract class MovieServiceImpl implements MovieService {

    private MovieService movieService;
    private MapperFacade mapperFacade;

    @Autowired
    public MovieServiceImpl(MovieService movieService, MapperFacade mapperFacade) {
        this.movieService = movieService;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public MovieDto getMovieById(Long movieId) {
        MovieDto movieDto = movieService.getMovieById(movieId);
        return movieDto;
    }
    @Override
    public MovieDto getMovieById(Long movieId) {
        return movieService.getMovieById(movieId)
                .map(movieDto -> mapperFacade.map(movieDto, MovieDto.class))
                .orElse(null);
    }

    @Override
    public ResponseDto createMovie(MovieDto movieDto) {
        // You might perform additional logic or validation here if needed
        return mapperFacade.map(movieService.createMovie(movieDto), ResponseDto.class);
    }

    @Override
    public ResponseDto updateMovie(Long movieId, MovieDto updatedMovieDto) {
        Optional<MovieDto> existingMovieOptional = movieService.getMovieById(movieId);

        if (existingMovieOptional.isPresent()) {
            MovieDto existingMovie = existingMovieOptional.get();
            mapperFacade.map(updatedMovieDto, existingMovie);
            return mapperFacade.map(movieService.updateMovie(existingMovie), ResponseDto.class);
        } else {
            return null; // or throw an exception, depending on your requirements
        }
    }

    @Override
    public ResponseDto deleteMovie(Long movieId) {
        movieService.deleteMovie(movieId);
        return new ResponseDto("Movie deleted successfully", true);
    }
}
