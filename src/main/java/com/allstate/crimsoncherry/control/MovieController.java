package com.allstate.crimsoncherry.control;

import com.allstate.crimsoncherry.entity.Actor;
import com.allstate.crimsoncherry.entity.Movie;
import com.allstate.crimsoncherry.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public List<Movie> getAllMovies(){
        System.out.println("movies" );
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Optional<Movie> getMoviesById(@PathVariable long id){
        return movieService.findMoviesById(id);
    }

    @GetMapping()
    public List<Movie> getMoviesByDirector(@RequestParam String director){
        return movieService.findMoviesByDirector(director);
    }


    @PostMapping("/save")
    public void saveMovie(@RequestBody Movie movie){
        movieService.saveMovie(movie);
        System.out.println("Movie Added");
    }

    @PostMapping("/saveAll")
    public void saveAllMovies(@RequestBody List<Movie> movies ){
        movieService.saveAllMovies(movies);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        movieService.deleteById(id);
    }

}