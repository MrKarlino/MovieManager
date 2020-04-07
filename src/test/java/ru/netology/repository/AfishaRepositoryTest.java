package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {

    private AfishaRepository repository;
    private Movie movie1 = new Movie(1);
    private Movie movie2 = new Movie(2);
    private Movie[] moviesToAdd = { movie1,  movie2 };

    @BeforeEach
    void setUp() {
        repository = new AfishaRepository();
        repository.setMovies(moviesToAdd);
    }

    @Test
    void testFindAll() {
        Movie[] actual = repository.findAll();
        assertArrayEquals(moviesToAdd, actual);
    }

    @Test
    void testSave() {
        Movie movie3 = new Movie();
        repository.save(movie3);
        int actual = repository.findAll().length;
        int expected = moviesToAdd.length + 1;
        assertEquals(expected, actual);
    }

    @Test
    void testFindById() {
        int movieId = 1;
        Movie actual = repository.findById(movieId);
        Movie expected = movie1;
        assertEquals(expected, actual);
    }

    @Test
    void testFindByIdCrash() {
        int movieId = 3;
        Movie actual = repository.findById(movieId);
        Movie expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void testRemoveById() {
        int movieId = 1;
        repository.removeById(movieId);
        int expected = moviesToAdd.length - 1;
        int actual = repository.findAll().length;
        assertEquals(expected, actual);
    }

    @Test
    void testRemoveAll() {
        repository.removeAll();
        Assertions.assertEquals(repository.findAll().length, 0);
    }
}
