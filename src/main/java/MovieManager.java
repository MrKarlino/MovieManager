public class MovieManager {
    private int numberOfMoviesToGet = 10;
    private MovieRepository repository;

    public MovieManager() {
        this.repository = new MovieRepository();
    }

    public MovieManager(MovieRepository repository, int numberOfMoviesToGet) {
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

    public void removeById(int movieId) {
        repository.removeById(movieId);
    }

    public Movie[] findAll() {
        return repository.findAll();
    }

    public Movie findById(int movieId) {
        return repository.findById(movieId);
    }

    public void removeAll() {
        repository.removeAll();
    }

    protected void setNumberOfMoviesToGet(int numberOfMoviesToGet) {
        this.numberOfMoviesToGet = numberOfMoviesToGet;
    }
}
