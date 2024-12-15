package com.delflix.model;

public class DVD {
    private String title;
    private String genre;
    private int year;
    private boolean available;
    private Director director;

    public DVD(String title, String genre, int year, Director director) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.director = director;
        this.available = true;  
    }

    // Getters e Setters
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    public Director getDirector() {
        return director;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
