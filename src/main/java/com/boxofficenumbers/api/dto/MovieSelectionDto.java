package com.boxofficenumbers.api.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "movie_selection")
public class MovieSelectionDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int selectionOrder;
    private String movieTitle;
    private double boxOfficeGross;
    @JsonBackReference
    @ManyToOne
    private UserMovieSelectionDto userMovieSelection;
}
