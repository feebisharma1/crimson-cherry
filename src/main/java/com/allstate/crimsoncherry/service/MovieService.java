package com.allstate.crimsoncherry.service;

import com.allstate.crimsoncherry.entity.Actor;
import com.allstate.crimsoncherry.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> getAllMovies();

    Optional<Movie> findMoviesById(long id);

    void saveMovie(Movie movie);

    void saveAllMovies(List<Movie> movies);

    List<Movie> findMoviesByDirector(String director);

    void deleteById(long id);

}
