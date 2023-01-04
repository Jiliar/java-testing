package co.com.jsolutions.movies.data;

import co.com.jsolutions.movies.model.Genre;
import co.com.jsolutions.movies.model.Movie;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class MovieRepositoryJdbcTest {

    private static DataSource dataSource;
    private MovieRepositoryJdbc movieRepositoryJdbc;
    private Collection<Movie> movies;

    @Before
    public void setUp() throws SQLException {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts\\test-data.sql"));
        JdbcTemplate  jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies(){
        movies = movieRepositoryJdbc.findAll();
        assertEquals(movies, Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        ));
    }

    @Test
    public void load_movie_by_id() {
        Movie movie = movieRepositoryJdbc.findById(2);
        assertEquals(movie, new Movie(2, "Memento", 113, Genre.THRILLER));
    }

    @Test
    public void insert_a_movie(){
        Movie movie = new Movie(4,"Super 8", 112, Genre.THRILLER);
        movieRepositoryJdbc.saveOrUpdate(movie);
        Movie movieFromDB = movieRepositoryJdbc.findById(4);
        assertEquals(movie, movieFromDB);
    }

    @After
    public void teaDown() throws SQLException {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("DROP ALL OBJECTS DELETE FILES");
    }
}
