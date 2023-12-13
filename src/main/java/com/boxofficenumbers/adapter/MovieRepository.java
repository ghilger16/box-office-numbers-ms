package com.boxofficenumbers.adapter;

import com.boxofficenumbers.api.dto.MovieDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieDto, Long> {
}
