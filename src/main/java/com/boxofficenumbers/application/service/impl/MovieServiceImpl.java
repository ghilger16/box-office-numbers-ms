package com.boxofficenumbers.application.service.impl;

import com.boxofficenumbers.adapter.MovieRepository;
import com.boxofficenumbers.api.dto.MovieDto;
import com.boxofficenumbers.api.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    public MovieDto getMovieById(Long id) {
        return movieRepository.getMovieById(id);
    }

    public ResponseDto createMovie(MovieDto movieDto) {
        movieRepository.createMovie(movieDto);

        ResponseDto response = new ResponseDto();
        response.setId(movieDto.getId().intValue());
        response.setMessage("Movie created successfully");
        response.setHasError(false);

        return response;
    }

    public ResponseDto updateMovie(Long movieId, MovieDto updatedMovieDto) {
        MovieDto existingMovie = getMovieById(movieId);

        if (existingMovie != null) {
            existingMovie.setTitle(updatedMovieDto.getTitle());
            existingMovie.setReleaseDate(updatedMovieDto.getReleaseDate());

            ResponseDto response = new ResponseDto();
            response.setId(existingMovie.getId().intValue()); // Assuming id is an int in the response
            response.setMessage("Movie updated successfully");
            response.setHasError(false);

            return response;
        } else {
            ResponseDto response = new ResponseDto();
            response.setId(0); // Assuming 0 as an indication of an error
            response.setMessage("Movie not found");
            response.setHasError(true);

            return response;
        }
    }

    public ResponseDto deleteMovie(Long movieId) {
        // Implement logic to delete the movie from the repository
        // For simplicity, I'm assuming a deleteMovie method in the repository
        MovieDto existingMovie = getMovieById(movieId);

        if (existingMovie != null) {
            movieRepository.remove(existingMovie);

            ResponseDto response = new ResponseDto();
            response.setId(existingMovie.getId().intValue()); // Assuming id is an int in the response
            response.setMessage("Movie deleted successfully");
            response.setHasError(false);

            return response;
        } else {
            ResponseDto response = new ResponseDto();
            response.setId(0); // Assuming 0 as an indication of an error
            response.setMessage("Movie not found");
            response.setHasError(true);

            return response;
        }
    }
}
