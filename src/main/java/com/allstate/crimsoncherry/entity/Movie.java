package com.allstate.crimsoncherry.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "id")
    @ManyToMany
    private List<Actor> actors;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "movie")
    private List<Review> reviews = new ArrayList<>();
    private String runtime;
    @Column(name = "director")
    private String director;
    private String budget;
    @Column(name = "studio")
    private String studio;
    private String rating;
    @Column(name = "name")
    private String name;
    private String year;
    private String synopsis;

    public Movie(){}

    public Movie(Long id, String runtime, String director, String budget, List<Actor> actors, String studio, String rating, String name, String year, String synopsis) {
        this.id = id;
        this.runtime = runtime;
        this.director = director;
        this.budget = budget;
        this.actors = actors;
        this.studio = studio;
        this.rating = rating;
        this.name = name;
        this.year = year;
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", runtime='" + runtime + '\'' +
                ", director='" + director + '\'' +
                ", budget='" + budget + '\'' +
                ", actors='" + actors + '\'' +
                ", studio='" + studio + '\'' +
                ", rating='" + rating + '\'' +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final Movie movie = (Movie) o;
        return Objects.equals(this.id, movie.id) && Objects.equals(this.actors, movie.actors) && Objects.equals(this.runtime, movie.runtime) && Objects.equals(this.director, movie.director) && Objects.equals(this.budget, movie.budget) && Objects.equals(this.studio, movie.studio) && Objects.equals(this.rating, movie.rating) && Objects.equals(this.name, movie.name) && Objects.equals(this.year, movie.year) && Objects.equals(this.synopsis, movie.synopsis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRuntime(), getDirector(), getBudget(), getActors(), getStudio(), getRating(), getName(), getYear(), getSynopsis());
    }


    public List<Review> getReviews() {
        return this.reviews;
    }

    public void setReviews(final List<Review> reviews) {
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

}
