package com.allstate.crimsoncherry.control;

import com.allstate.crimsoncherry.entity.Movie;
import com.allstate.crimsoncherry.entity.Review;
import com.allstate.crimsoncherry.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

//    @Autowired
//    private MovieService movieService;
//
//    @Autowired
//    private ActorService actorService;

    @GetMapping("/api/review/{id}")
    public Optional<Review> getReviewById(@PathVariable("id") Long id) {
        System.out.println("Getting review with id" + id);
        return reviewService.getReviewById(id);
    }

    @GetMapping("/api/review")
    public List<Review> getAllReviews() {
        System.out.println("Getting all reviews");
        return reviewService.getAllReviews();
    }

    @GetMapping("/api/movie/{id}/review")
    public Object getReviewsByMovie(@PathVariable("id") Movie movieId) {
        System.out.println("Getting reviews for movie " + movieId);
        try {
            return reviewService.getReviewsByMovie(movieId);
        } catch(Exception e) {
            return "No reviews found for movie with id " + movieId + "<br />\n" + e;
        }
    }
}
