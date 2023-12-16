package com.boxofficenumbers.api.dto;

public class UserSelectionDto {
    private Long id;
    private String title;
    private int boxOfficeGuess;
    private int order;

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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
