package com.boxofficenumbers.api.impl.rest;

import com.boxofficenumbers.api.dto.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;
    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        List<MovieDto> movies = movieRepository.findAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

     @GetMapping("/{movieId}")
    public ResponseEntity<?> getMovieById(@PathVariable Long movieId) {
        Optional<MovieDto> movie = movieRepository.findById(movieId);
        if (movie.isPresent()) {
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Movie not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createMovie(@RequestBody MovieDto movie) {
        MovieDto createdMovie = movieRepository.save(movie);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<?> updateMovie(@PathVariable Long movieId, @RequestBody MovieDto updatedMovie) {
        Optional<MovieDto> existingMovieOptional = movieRepository.findById(movieId);
        if (existingMovieOptional.isPresent()) {
            MovieDto existingMovie = existingMovieOptional.get();
            existingMovie.setTitle(updatedMovie.getTitle());
            existingMovie.setBoxOfficeGross(updatedMovie.getBoxOfficeGross());
            // Update other fields as needed

            MovieDto updated = movieRepository.save(existingMovie);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Movie not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long movieId) {
        Optional<MovieDto> movieOptional = movieRepository.findById(movieId);
        if (movieOptional.isPresent()) {
            movieRepository.deleteById(movieId);
            return new ResponseEntity<>("Movie deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Movie not found", HttpStatus.NOT_FOUND);
        }
    }
}
