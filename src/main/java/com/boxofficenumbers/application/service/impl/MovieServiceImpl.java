package com.boxofficenumbers.application.service.impl;

import com.boxofficenumbers.adapter.MovieRepository;
import com.boxofficenumbers.api.dto.MovieDto;
import com.boxofficenumbers.api.dto.ResponseDto;
import com.boxofficenumbers.application.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll();
    }

    public MovieDto getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

     public ResponseDto createMovie(MovieDto movieDto) {
        movieRepository.save(movieDto);

        ResponseDto response = new ResponseDto();
        response.setId(movieDto.getId().intValue());
        response.setMessage("Movie created successfully");
        response.setHasError(false);

        return response;
    }

    public ResponseDto updateMovie(Long movieId, MovieDto updatedMovieDto) {
        MovieDto existingMovie = movieRepository.findById(movieId).orElse(null);

        if (existingMovie != null) {
            existingMovie.setTitle(updatedMovieDto.getTitle());
            existingMovie.setReleaseDate(updatedMovieDto.getReleaseDate());

            movieRepository.save(existingMovie);

            ResponseDto response = new ResponseDto();
            response.setId(existingMovie.getId().intValue());
            response.setMessage("Movie updated successfully");
            response.setHasError(false);

            return response;
        } else {
            ResponseDto response = new ResponseDto();
            response.setId(0);
            response.setMessage("Movie not found");
            response.setHasError(true);

            return response;
        }
    }

    public ResponseDto deleteMovie(Long movieId) {
        if (movieRepository.existsById(movieId)) {
            movieRepository.deleteById(movieId);

            ResponseDto response = new ResponseDto();
            response.setId(movieId.intValue());
            response.setMessage("Movie deleted successfully");
            response.setHasError(false);

            return response;
        } else {
            ResponseDto response = new ResponseDto();
            response.setId(0);
            response.setMessage("Movie not found");
            response.setHasError(true);

            return response;
        }
    }
}
