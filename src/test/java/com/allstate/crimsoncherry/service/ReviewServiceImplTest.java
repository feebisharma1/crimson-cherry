package com.allstate.crimsoncherry.service;

import com.allstate.crimsoncherry.entity.Movie;
import com.allstate.crimsoncherry.entity.Review;
import com.allstate.crimsoncherry.repository.MovieRepository;
import com.allstate.crimsoncherry.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReviewServiceImplTest {

    @InjectMocks
    MovieService mockMovieService;

    @InjectMocks
    MovieRepository mockMovieRepository;

    @InjectMocks
    ReviewRepository mockReviewRepository;

    @InjectMocks
    ReviewServiceImpl reviewService;

//    @Test
//    void getReviewById_shouldReturnOneMovie() {
//        when(mockMovieRepository.getById()).thenReturn(
//                new Movie());
//        assertEquals(6, business.calculateSumUsingDataService());
//    }

    @Test
    void testSaveReview() {
//        Review review = new Review(1L, "Joe", "Fine", 3, null, "Synopsis", 1L);
//        //Mockito.when(mockReviewRepository.save(Mockito.any())).thenReturn(review);
//        reviewService.addReview(review);
//        Mockito.verify(mockReviewRepository).save(Mockito.any());
    }
}