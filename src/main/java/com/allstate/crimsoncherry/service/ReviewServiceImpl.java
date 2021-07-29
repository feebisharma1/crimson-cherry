package com.allstate.crimsoncherry.service;

import com.allstate.crimsoncherry.entity.Actor;
import com.allstate.crimsoncherry.entity.Movie;
import com.allstate.crimsoncherry.entity.Review;
import com.allstate.crimsoncherry.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = {NullPointerException.class})
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Override
    public Optional<Review> getReviewById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Review> getAllReviews() {
        return repository.findAll();
    }

    @Override
    public List<Review> getReviewsByMovie(Movie movieId) {
        return repository.getAllByMovie(movieId);
    }

    @Override
    public List<Review> getReviewsByActor(Actor actor) {
        return null;
    }
}
