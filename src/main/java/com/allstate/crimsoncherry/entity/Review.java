package com.allstate.crimsoncherry.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private LocalDateTime reviewedOn;
    private String synopsis;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Movie movie;

// Add to Movie entity class
//    @OneToMany(cascade = CascadeType.PERSIST)
//    private List<Review> reviews;

    // No parameter constructor
    public Review() {}

    // Full parameter constructor
    public Review(Long id, String reviewerName, String review, Integer numberOfStars, LocalDateTime reviewedOn, String synopsis) {
        this.id = id;
        this.reviewerName = reviewerName;
        this.review = review;
        this.numberOfStars = numberOfStars;
        this.reviewedOn = reviewedOn;
        this.synopsis = synopsis;
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

    public LocalDateTime getReviewedOn() {
        return reviewedOn;
    }

    public void setReviewedOn(LocalDateTime reviewedOn) {
        this.reviewedOn = reviewedOn;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
