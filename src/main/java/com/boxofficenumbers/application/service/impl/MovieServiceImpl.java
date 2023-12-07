package com.boxofficenumbers.application.service.impl;

import com.boxofficenumbers.api.dto.MovieDto;
import com.boxofficenumbers.api.dto.ResponseDto;
import com.boxofficenumbers.application.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ModelMapper modelMapper; // Assuming you use ModelMapper for entity-DTO conversion

    @Override
    public List<MovieDto> getAllMovies() {
        List<MovieDto> movieDtos = movieService.getAllMovies().stream()
                .map(movie -> modelMapper.map(movie, MovieDto.class))
                .collect(Collectors.toList());
        return movieDtos;
    }

    @Override
    public MovieDto getMovieById(Long movieId) {
        Optional<MovieDto> movieDtoOptional = movieService.findById(movieId)
                .map(movie -> modelMapper.map(movie, MovieDto.class));
        return movieDtoOptional.orElse(null);
    }

    @Override
    public ResponseDto createMovie(MovieDto movieDto) {
        // Assuming modelMapper can also map from MovieDto to Movie
        Movie movie = modelMapper.map(movieDto, Movie.class);
        Movie savedMovie = movieService.save(movie);
        return modelMapper.map(savedMovie, MovieDto.class);
    }

    @Override
    public ResponseDto updateMovie(Long movieId, MovieDto updatedMovieDto) {
        Optional<Movie> existingMovieOptional = movieService.findById(movieId);

        if (existingMovieOptional.isPresent()) {
            Movie existingMovie = existingMovieOptional.get();
            modelMapper.map(updatedMovieDto, existingMovie);
            Movie updatedMovie = movieService.save(existingMovie);
            return modelMapper.map(updatedMovie, MovieDto.class);
        } else {
            return null; // or throw an exception, depending on your requirements
        }
    }

    @Override
    public ResponseDto deleteMovie(Long movieId) {
        movieService.deleteById(movieId);
    }
}
