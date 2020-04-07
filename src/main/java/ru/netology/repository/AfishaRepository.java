package ru.netology.repository;

import ru.netology.domain.Movie;

public class AfishaRepository {
    private Movie[] movies = new Movie[0];

    public Movie[] findAll() {
        return movies;
    }

    public void save(Movie movie) {

        Movie[] newMovies = new Movie[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            newMovies[i] = movies[i];
        }
        newMovies[newMovies.length - 1] = movie;
        movies = newMovies;
    }

    public Movie findById(int movieId) {
        for (Movie i: movies) {
            if (i.getId() == movieId) {
                return i;
            }
        }
        return null;
    }

    public void removeById(int movieId) {
        int length = movies.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie i : movies) {
            if (i.getId() != movieId) {
                tmp[index] = i;
                index++;
            }
        }
        movies = tmp;
    }

    public void removeAll() {
        movies = new Movie[0];
    }

    protected void setMovies(Movie[] movies) {
        this.movies = movies;
    }

}
