package com.allstate.crimsoncherry.repository;

import com.allstate.crimsoncherry.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    public List<Movie> findAllById(long id);
    public List<Movie> findAllByDirector(String director);
    public List<Movie> findAllByName(String movieName);
}
