package com.boxofficenumbers.adapter;

import com.boxofficenumbers.api.dto.MovieDto;
import com.boxofficenumbers.api.dto.ResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieDto, Long> {

    List<MovieDto> getAllMovies();

    MovieDto getMovieById(long id);

    ResponseDto createMovie(MovieDto movieDto);

    ResponseDto updateMovie(MovieDto movieDto);

    ResponseDto deleteMovie(long id);
}
