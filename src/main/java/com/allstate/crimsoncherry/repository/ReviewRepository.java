package com.allstate.crimsoncherry.repository;

import com.allstate.crimsoncherry.entity.Actor;
import com.allstate.crimsoncherry.entity.Movie;
import com.allstate.crimsoncherry.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    public Review getById(Long id);
    public List<Review> getAllByMovie(Movie movieId);
    //public List<Review> getAllByActor(Actor actor);
}
