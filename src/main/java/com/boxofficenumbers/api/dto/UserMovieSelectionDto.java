package com.boxofficenumbers.api.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "user_movie_selection")
public class UserMovieSelectionDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    @JsonManagedReference
    @OneToMany(mappedBy = "userMovieSelection", cascade = CascadeType.ALL)
    private List<MovieSelectionDto> movieSelections;
}
