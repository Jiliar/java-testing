package co.com.jsolutions.movies.service;

import co.com.jsolutions.movies.data.MovieRepository;
import co.com.jsolutions.movies.model.Genre;
import co.com.jsolutions.movies.model.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(){}

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }
    public List<Movie> findMoviesByGenre(Genre genre){
       return  movieRepository.findAll()
               .stream().
               filter(x-> genre == x.getGenre() )
               .collect(Collectors.toList());
    }

    public List<Movie> findMoviesByLength(int i) {
        return  movieRepository.findAll()
                .stream().
                filter(x-> x.getMinutes() <= i )
                .collect(Collectors.toList());
    }
}
