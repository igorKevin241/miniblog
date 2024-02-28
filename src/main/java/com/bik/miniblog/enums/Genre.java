package com.bik.miniblog.enums;

public enum Genre {
    HOMME("HOMME"),
    FEMME("FEMME");


    private String genre;
    Genre(String genre) {
        this.genre = genre;
    }

    public String getUserRole() {
        return genre;
    }
}
