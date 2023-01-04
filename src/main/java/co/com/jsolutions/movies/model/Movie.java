package co.com.jsolutions.movies.model;

import java.util.Objects;

public class Movie {

    private Integer id;
    private String name;
    private int minutes;
    private Genre genre;

    public Movie() {
    }
    public Movie(String name, int minutes, Genre genre) {
        this(null, name, minutes, genre);
    }
    public Movie(Integer id, String name, int minutes, Genre genre) {
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMinutes() {
        return minutes;
    }
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie movie)) return false;
        return getMinutes() == movie.getMinutes() && getId().equals(movie.getId()) && getName().equals(movie.getName()) && getGenre() == movie.getGenre();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getMinutes(), getGenre());
    }
}
