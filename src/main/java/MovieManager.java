public class MovieManager {
    private int numberOfMoviesToGet = 10;
    private Movie[] movies = new Movie[0];

    public MovieManager() {}

    public MovieManager(int numberOfMoviesToGet) {
        this.numberOfMoviesToGet = numberOfMoviesToGet;
    }

    public void addMovie(Movie movie) {

        Movie[] newMovies = new Movie[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            newMovies[i] = movies[i];
        }
        newMovies[newMovies.length - 1] = movie;
        movies = newMovies;
    }

    public Movie[] getMovies() {
        int count = Math.min(numberOfMoviesToGet, movies.length);
        Movie[] result = new Movie[count];
        int displace = movies.length - result.length;
        for (int i = movies.length - 1; i > movies.length - 1 - count; i--) {
            result[i - displace] = movies[i];
        }

        for (int i = 0; i < result.length / 2; i++) {
            Movie temp = result[i];
            int mirrorIndex = result.length - 1 - i;
            result[i] = result[mirrorIndex];
            result[mirrorIndex] = temp;
        }
        return result;

    }

    protected int getMovieCount() {
        return movies.length;
    }
}
