import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.MalformedParameterizedTypeException;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {

    private MovieRepository repository;
    private Movie movie1 = new Movie();
    private Movie movie2 = new Movie();
    private Movie[] moviesToAdd = { movie1,  movie2 };

    @BeforeEach
    void setUp() {
        repository = new MovieRepository();
        repository.setMovies(moviesToAdd);
    }

    @Test
    void testFindAll() {
        Movie[] actual = repository.findAll();
        assertArrayEquals(actual, moviesToAdd);
    }

    @Test
    void testSave() {
        Movie movie3 = new Movie();
        repository.save(movie3);
        int actual = repository.findAll().length;
        int expected = moviesToAdd.length + 1;
        assertEquals(actual, expected);
    }

    @Test
    void testFindById() {
        int movieId = 1;
        movie1.setMovieId(movieId);
        Movie actual = repository.findById(movieId);
        Movie expected = movie1;
        assertEquals(expected, actual);
    }

    @Test
    void testFindByIdCrash() {
        int movieId = 1;
        Movie actual = repository.findById(movieId);
        Movie expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void testRemoveById() {
        int movieId = 1;
        movie1.setMovieId(movieId);
        repository.removeById(movieId);
        int expected = moviesToAdd.length - 1;
        int actual = repository.findAll().length;
        assertEquals(actual, expected);
    }

    @Test
    void testRemoveAll() {
        repository.removeAll();
        assertEquals(repository.findAll().length, 0);
    }
}
