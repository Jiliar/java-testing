package co.com.jsolutions.movies.data;

import co.com.jsolutions.movies.model.Genre;
import co.com.jsolutions.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;
import java.util.Objects;

public class MovieRepositoryJdbc implements MovieRepository{

    private JdbcTemplate jdbcTemplate;

    private static final RowMapper<Movie> movieMapper = (rs, rowNum) -> new Movie(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("minutes"),
            Genre.valueOf(rs.getString("genre")));

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] args = {id};
        return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE id = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("INSERT INTO movies (id, name, minutes, genre) VALUES (?,?,?,?)",
                movie.getId(),
                movie.getName(),
                movie.getMinutes(),
                movie.getGenre().toString());
    }
}
