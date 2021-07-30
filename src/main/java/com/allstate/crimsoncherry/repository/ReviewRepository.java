package com.allstate.crimsoncherry.repository;

import com.allstate.crimsoncherry.entity.Movie;
import com.allstate.crimsoncherry.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review getById(Long id);
    List<Review> getAllByMovie(Movie movie);
    List<Review> getAllByReviewerName(String reviewerName);
    List<Review> getAllByNumberOfStars(Integer stars);
    List<Review> getAllByNumberOfStarsGreaterThanEqual(Integer stars);
}
