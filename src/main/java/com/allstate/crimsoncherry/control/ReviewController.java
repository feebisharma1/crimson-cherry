package com.allstate.crimsoncherry.control;

import com.allstate.crimsoncherry.entity.Movie;
import com.allstate.crimsoncherry.entity.Review;
import com.allstate.crimsoncherry.service.ReviewService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    //@Autowired
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

//    @Autowired
//    private MovieService movieService;
//
//    @Autowired
//    private ActorService actorService;

    @GetMapping("/{id}")
    public Optional<Review> getReviewById(@PathVariable("id") Long id) {
        System.out.println("Getting review with id " + id);
        return reviewService.getReviewById(id);
    }

    @GetMapping()
    public List<Review> reviewsBySearching(
            @RequestParam(value = "movieId", required = false) Long movieId,
            @RequestParam(value = "reviewer", required = false) String reviewer,
            @RequestParam(value = "stars", required = false) Integer stars,
            @RequestParam(value = "minStars", required = false) Integer minStars) {
        // Reviews by Movie
        if (movieId != null) {
            System.out.println("Getting reviews for movie " + movieId);
            return reviewService.getReviewsByMovieId(movieId);
        }

        // Reviews by reviewer
        if (reviewer != null) {
            System.out.println("Getting reviews for reviewer " + reviewer);
            return reviewService.getReviewsByReviewer(reviewer);
        }

        // Reviews by stars
        if (stars != null) {
            System.out.println("Getting reviews with " + stars + " stars");
            return reviewService.getReviewsByNumberOfStars(stars);
        }
        if (minStars != null) {
            System.out.println("Getting reviews with a minimum of" + minStars + " stars");
            return reviewService.getReviewsWithMinStars(minStars);
        }

        // No Request Parameters so return all reviews
        System.out.println("Getting all reviews");
        return reviewService.getAllReviews();
    }

    @PostMapping()
    public Map<String, Object> addReview(@RequestBody HashMap<String, String> reviewHashMap) {
        System.out.println("Adding a new review:" + reviewHashMap);
        Long newId = reviewService.addReview(reviewHashMap);
        Map<String, Object> returnValueMap = new HashMap<>();
        returnValueMap.put("id", newId);
        return returnValueMap;
    }
}
