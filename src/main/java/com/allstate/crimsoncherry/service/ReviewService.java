package com.allstate.crimsoncherry.service;

import com.allstate.crimsoncherry.entity.Actor;
import com.allstate.crimsoncherry.entity.Movie;
import com.allstate.crimsoncherry.entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    public Optional<Review> getReviewById(Long id);
    public List<Review> getAllReviews();
    public List<Review> getReviewsByMovie(Movie movie);
    public List<Review> getReviewsByActor(Actor actor);
}
