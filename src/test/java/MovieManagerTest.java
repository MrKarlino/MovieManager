import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    @Test
    void testAddMovie() {
        MovieManager manager = new MovieManager();
        Movie movie = new Movie();
        manager.addMovie(movie);
        int expected =  1;
        int actual = manager.getMovieCount();
        assertEquals(expected, actual);

    }

    @Test
    void testGetMoviesUnderLimit() {
        MovieManager manager = new MovieManager();

        Movie[] moviesToAdd = { new Movie(),  new Movie() };
        for (var movie:moviesToAdd) {
            manager.addMovie(movie);
        }
        int expected = moviesToAdd.length;
        int actual = manager.getMovies().length;
        assertEquals(expected, actual);

    }

    @Test
    void testGetMoviesOverLimit() {
        int numberOfMoviesToGet = 4;
        MovieManager manager = new MovieManager(numberOfMoviesToGet);

        Movie[] moviesToAdd = { new Movie(),  new Movie(), new Movie(), new Movie(), new Movie()};
        for (var movie:moviesToAdd) {
            manager.addMovie(movie);
        }
        int expected = numberOfMoviesToGet;
        int actual = manager.getMovies().length;
        assertEquals(expected, actual);

    }

    @Test
    void testGetMovieOrder() {
        MovieManager manager = new MovieManager();

        Movie[] moviesToAdd = { new Movie(),  new Movie(), new Movie(), new Movie(), new Movie()};
        for (var movie:moviesToAdd) {
            manager.addMovie(movie);
        }
        Movie lastMovie = new Movie();
        manager.addMovie(lastMovie);
        Movie[] lastMovies = manager.getMovies();
        assertEquals(lastMovie, lastMovies[0]);
    }
}
