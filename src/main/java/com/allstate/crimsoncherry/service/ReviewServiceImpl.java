package com.allstate.crimsoncherry.service;

import com.allstate.crimsoncherry.entity.Movie;
import com.allstate.crimsoncherry.entity.Review;
import com.allstate.crimsoncherry.exception.UnacceptableRequestException;
import com.allstate.crimsoncherry.repository.MovieRepository;
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
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }



    @Override
    public List<Review> getReviewsByMovieId(Long movieId) {
        Movie movie = movieRepository.getById(movieId);
        System.out.println(movie);
        if (movie == null) return null;
        List<Review> reviews = reviewRepository.getAllByMovie(movie);
        System.out.println(reviews);
        for (Review review : reviews) {
            System.out.println(review);
        }
        return reviews;
    }

    @Override
    public List<Review> getReviewsByNumberOfStars(Integer stars) {
        return reviewRepository.getAllByNumberOfStars(stars);
    }

    @Override
    public List<Review> getReviewsWithMinStars(Integer stars) {
        return reviewRepository.getAllByNumberOfStarsGreaterThanEqual(stars);
    }

    @Override
    public List<Review> getReviewsByActor(Long actorId) {
        return null;
    }

    @Override
    public List<Review> getReviewsByReviewer(String reviewer) {
        return reviewRepository.getAllByReviewerName(reviewer);
    }

    @Override
    public Long addReview(Review review) {
        if(review.getReviewerName() == null || review.getReviewerName().equals("")) {
            throw new UnacceptableRequestException("Must have a valid Reviewer Name");
        }
        if (review.getNumberOfStars() == null || review.getNumberOfStars() < 0
            || review.getNumberOfStars() > 5) {
            throw new UnacceptableRequestException("Reviews must have a star rating between 0 and 5");
        }
        if (review.getReview() == null || review.getReview().equals("")) {
            throw new UnacceptableRequestException("You must provide review text in your review");
        }
        //reviewRepository.save(review);
        //Movie movie = movieRepository.getById(review.getMovie().getId());
        Movie movie = movieRepository.getById(review.getMovieId());
        movie.getReviews().add(review);
        movieRepository.save(movie);
        return review.getId();
    }
}
