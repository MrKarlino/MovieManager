package ru.netology.domain;

public class Movie {

    private int id;
    private int movieGenre;
    private int coverIconId;
    private String name;

    public Movie() {}

    public Movie(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(int movieGenre) {
        this.movieGenre = movieGenre;
    }

    public int getCoverIconId() {
        return coverIconId;
    }

    public void setCoverIconId(int coverIconId) {
        this.coverIconId = coverIconId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
