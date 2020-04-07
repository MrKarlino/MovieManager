package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private int numberOfMoviesToGet = 10;
    private AfishaRepository repository;

    public AfishaManager() {
        this.repository = new AfishaRepository();
    }

    public AfishaManager(AfishaRepository repository, int numberOfMoviesToGet) {
        this.repository = repository;
        this.numberOfMoviesToGet = numberOfMoviesToGet;
    }

    public void addMovie(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getMovies() {
        Movie[] movies = repository.findAll();
        int count = Math.min(numberOfMoviesToGet, movies.length);
        Movie[] result = new Movie[count];

        int displace = movies.length - result.length;

        for (int i = 0; i <  result.length; i++) {
            result[result.length - 1 - i] = movies[i + displace];
        }
        return result;

    }

    public Movie[] findAll() {
        return repository.findAll();
    }

    protected void setNumberOfMoviesToGet(int numberOfMoviesToGet) {
        this.numberOfMoviesToGet = numberOfMoviesToGet;
    }
}
