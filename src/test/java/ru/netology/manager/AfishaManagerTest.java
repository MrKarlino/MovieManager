package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    AfishaManager manager;

    private Movie movie1 = new Movie(1);
    private Movie movie2 = new Movie(2);

    @Test
    void testAddMovie() {
        Movie[] addedMovies = {movie1};
        doReturn(addedMovies).when(repository).findAll();

        manager.addMovie(movie1);

        Movie[] expected = {movie1};
        Movie[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void testGetMoviesUnderLimit() {
        int numberOfMoviesToGet = 10;
        Movie[] moviesToAdd = {movie1, movie2};
        manager.setNumberOfMoviesToGet(numberOfMoviesToGet);
        doReturn(moviesToAdd).when(repository).findAll();
        int expected = moviesToAdd.length;
        int actual = manager.getMovies().length;
        assertEquals(expected, actual);
    }

    @Test
    void testGetMoviesOverLimit() {
        int numberOfMoviesToGet = 2;
        manager.setNumberOfMoviesToGet(numberOfMoviesToGet);
        Movie[] moviesToAdd = {new Movie(3), new Movie(4), movie1, movie2};
        doReturn(moviesToAdd).when(repository).findAll();
        int expected = numberOfMoviesToGet;
        int actual = manager.getMovies().length;
        assertEquals(expected, actual);

    }

    @Test
    void testGetMovieOrder() {
        int numberOfMoviesToGet = 2;
        manager.setNumberOfMoviesToGet(numberOfMoviesToGet);
        Movie[] moviesToAdd = {movie1, movie2};
        doReturn(moviesToAdd).when(repository).findAll();
        Movie[] expected = {movie2, movie1};
        Movie[] actual = manager.getMovies();
        assertArrayEquals(expected, actual);
    }
}
