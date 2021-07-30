package com.allstate.crimsoncherry.service;

import com.allstate.crimsoncherry.entity.Actor;
import com.allstate.crimsoncherry.entity.Movie;
import com.allstate.crimsoncherry.entity.Review;
import io.swagger.models.auth.In;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Optional<Review> getReviewById(Long id);
    List<Review> getAllReviews();
    List<Review> getReviewsByActor(Long actorId);
    List<Review> getReviewsByReviewer(String reviewer);
    List<Review> getReviewsByNumberOfStars(Integer stars);
    List<Review> getReviewsWithMinStars(Integer stars);
    List<Review> getReviewsByMovieId(Long movieId);
    Long addReview(Review review);
}
