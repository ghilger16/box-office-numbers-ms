package com.boxofficenumbers.api.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserSelectionDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int boxOfficeGuess;
    private int selectionOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBoxOfficeGuess() {
        return boxOfficeGuess;
    }

    public void setBoxOfficeGuess(int boxOfficeGuess) {
        this.boxOfficeGuess = boxOfficeGuess;
    }

    public int getSelectionOrder() {
        return selectionOrder;
    }

    public void setSelectionOrder(int selectionOrder) {
        this.selectionOrder = selectionOrder;
    }
}
