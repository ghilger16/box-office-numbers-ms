package com.boxofficenumbers.api.impl.rest;

import com.boxofficenumbers.api.dto.MovieDto;
import com.boxofficenumbers.api.dto.ResponseDto;
import com.boxofficenumbers.application.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {this.movieService = movieService;}

    @GetMapping
    public List<MovieDto> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{movieId}")
    public MovieDto getMovieById(@PathVariable Long movieId) {
        return movieService.getMovieById(movieId);
    }

    @PostMapping
    public ResponseDto createMovie(@RequestBody MovieDto movieDto) {
        return movieService.createMovie(movieDto);
    }

    @PutMapping("/{movieId}")
    public ResponseDto updateMovie(@PathVariable Long movieId, @RequestBody MovieDto updatedMovieDto) {
        return movieService.updateMovie(movieId, updatedMovieDto);
    }

    @DeleteMapping("/{movieId}")
    public ResponseDto deleteMovie(@PathVariable Long movieId) {
       return movieService.deleteMovie(movieId);
    }
}