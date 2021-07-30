package com.allstate.crimsoncherry.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "reviewer_name")
    private String reviewerName;
    private String review;
    @Column(name = "number_of_stars")
    private Integer numberOfStars;
    @Column(name = "reviewed_on")
    private Date reviewedOn;
    private String synopsis;
    @ManyToOne
    @JsonIgnore
    private Movie movie;

    @Transient
    @JsonIgnore
    private Long movieId;

    public String getMovieName(){
        if (movie == null) {
            return "Not Found";
        }
        return movie.getName();
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    // No parameter constructor
    public Review() {}

    // Full parameter constructor
    public Review(Long id, String reviewerName, String review, Integer numberOfStars, Date reviewedOn, String synopsis, Movie movie) {
        this.id = id;
        this.reviewerName = reviewerName;
        this.review = review;
        this.numberOfStars = numberOfStars;
        this.reviewedOn = reviewedOn;
        this.synopsis = synopsis;
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review1 = (Review) o;
        return id.equals(review1.id) && Objects.equals(reviewerName, review1.reviewerName) && Objects.equals(review, review1.review) && Objects.equals(numberOfStars, review1.numberOfStars) && Objects.equals(reviewedOn, review1.reviewedOn) && Objects.equals(synopsis, review1.synopsis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reviewerName, review, numberOfStars, reviewedOn, synopsis);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(Integer numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public Date getReviewedOn() {
        return reviewedOn;
    }

    public void setReviewedOn(Date reviewedOn) {
        this.reviewedOn = reviewedOn;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
