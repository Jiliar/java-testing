package co.com.jsolutions.movies.data;
import co.com.jsolutions.movies.data.MovieRepository;
import co.com.jsolutions.movies.model.Genre;
import co.com.jsolutions.movies.model.Movie;
import co.com.jsolutions.movies.service.MovieService;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceTest {

    private MovieRepository movieRepository;
    private MovieService movieService;
    private List<Movie> movies;

    private  List<Integer> proccesedMovies;

    @Before
    public void setup(){
        movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION),
                        new Movie(2, "Memento", 113, Genre.THRILLER),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY),
                        new Movie(4, "Super 8", 112, Genre.THRILLER),
                        new Movie(5, "Scream", 111, Genre.HORROR),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY),
                        new Movie(7, "Matrix", 136, Genre.ACTION)
                )
        );
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre(){
        movies =  movieService.findMoviesByGenre(Genre.COMEDY);
        assertEquals(this.getMoviesId(movies), Arrays.asList(3,6));
    }

    @Test
    public void return_movies_by_length(){
        movies =  movieService.findMoviesByLength(120);
        assertEquals(this.getMoviesId(movies), Arrays.asList(2,3,4,5,6));
    }

    public List<Integer> getMoviesId(List<Movie> movies){
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }

}
