package com.allstate.crimsoncherry.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String runtime;
    private String director;
    private String budget;
    private String address2;
    private String studio;
    private String rating;
    private String name;
    private String year;
    private String synopsis;

    public Movie(){}

    public Movie(Long id, String runtime, String director, String budget, String address2, String studio, String rating, String name, String year, String synopsis) {
        this.id = id;
        this.runtime = runtime;
        this.director = director;
        this.budget = budget;
        this.address2 = address2;
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
                ", address2='" + address2 + '\'' +
                ", studio='" + studio + '\'' +
                ", rating='" + rating + '\'' +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(getId(), movie.getId()) && Objects.equals(getRuntime(), movie.getRuntime()) && Objects.equals(getDirector(), movie.getDirector()) && Objects.equals(getBudget(), movie.getBudget()) && Objects.equals(getAddress2(), movie.getAddress2()) && Objects.equals(getStudio(), movie.getStudio()) && Objects.equals(getRating(), movie.getRating()) && Objects.equals(getName(), movie.getName()) && Objects.equals(getYear(), movie.getYear()) && Objects.equals(getSynopsis(), movie.getSynopsis());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRuntime(), getDirector(), getBudget(), getAddress2(), getStudio(), getRating(), getName(), getYear(), getSynopsis());
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

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
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
