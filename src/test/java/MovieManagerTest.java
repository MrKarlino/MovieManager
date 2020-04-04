import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class MovieManagerTest {
    @Mock
    private MovieRepository repository;
    @InjectMocks
    MovieManager manager;

    private Movie movie1 = new Movie();
    private Movie movie2 = new Movie();
    private Movie[] moviesToAdd = { movie1,  movie2 };

    @Test
    void testAllArgsConstructor() {
        MovieManager actual = new MovieManager(repository, 10);
        assertNotEquals(null, actual);
    }

    @Test
    void testAddMovie() {
        Movie newMovie = new Movie();
        Movie[] addedMovies = { newMovie };
        doReturn(addedMovies).when(repository).findAll();

        manager.addMovie(newMovie);

        Movie[] expected = { newMovie };
        Movie[] actual = manager.findAll();
        assertArrayEquals(actual, expected);
    }

    @Test
    void testGetMoviesUnderLimit() {
        int numberOfMoviesToGet = 10;
        Movie[] moviesToAdd = { movie1, movie2};
        manager.setNumberOfMoviesToGet(numberOfMoviesToGet);
        doReturn(moviesToAdd).when(repository).findAll();
        int expected = moviesToAdd.length;
        int actual = manager.getMovies().length;
        assertEquals(actual, expected);
    }

    @Test
    void testGetMoviesOverLimit() {
        int numberOfMoviesToGet = 2;
        manager.setNumberOfMoviesToGet(numberOfMoviesToGet);
        Movie[] moviesToAdd = { new Movie(), new Movie(), movie1, movie2};
        doReturn(moviesToAdd).when(repository).findAll();
        int expected = numberOfMoviesToGet;
        int actual = manager.getMovies().length;
        assertEquals(actual, expected);

    }

    @Test
    void testGetMovieOrder() {
        int numberOfMoviesToGet = 2;
        manager.setNumberOfMoviesToGet(numberOfMoviesToGet);
        Movie[] moviesToAdd = { movie1, movie2};
        doReturn(moviesToAdd).when(repository).findAll();
        Movie[] expected = { movie2, movie1 };
        Movie[] actual = manager.getMovies();
        assertArrayEquals(actual, expected);
    }

    @Test
    void testFindAll() {
        Movie[] moviesToAdd = { movie1, movie2};
        doReturn(moviesToAdd).when(repository).findAll();
        Movie[] expected = moviesToAdd;
        Movie[] actual = manager.findAll();
        assertArrayEquals(actual, expected);
    }

    @Test
    void testFindById() {
        int idToFind = 0;
        doReturn(movie1).when(repository).findById(idToFind);
        Movie expected = movie1;
        Movie actual = manager.findById(idToFind);
        assertEquals(actual, expected);
    }

    @Test
    void testRemoveById() {
        int idToRemove = 0;
        Movie[] moviesToReturn = { movie1 };
        doReturn(moviesToReturn).when(repository).findAll();
        manager.removeById(idToRemove);
        Movie[] expected = moviesToReturn;
        Movie[] actual = manager.findAll();
        assertArrayEquals(actual, expected);
    }

    @Test
    void testRemoveAll() {
        Movie[] moviesToReturn =new Movie[0];
        doReturn(moviesToReturn).when(repository).findAll();
        manager.removeAll();
        Movie[] expected = moviesToReturn;
        Movie[] actual = manager.findAll();
        assertArrayEquals(actual, expected);
    }
}
