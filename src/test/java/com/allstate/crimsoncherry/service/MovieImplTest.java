package com.allstate.crimsoncherry.service;

import com.allstate.crimsoncherry.entity.Actor;
import com.allstate.crimsoncherry.entity.Movie;
import com.allstate.crimsoncherry.repository.ActorRepository;
import com.allstate.crimsoncherry.repository.MovieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MovieImplTest {

    @Mock
    MovieRepository movieRepository;

    @InjectMocks
    MovieServiceImpl movieServiceImpl;

    @Test
    void getAllMovies_Test() {
        Mockito.when(movieRepository.findAll()).thenReturn(getAllMovies());

        List<Movie> result = movieServiceImpl.getAllMovies();

        assertEquals(2, result.size());
        assertEquals("test1", result.get(0).getName());
        assertEquals("test2", result.get(1).getName());
    }

    @Test
    void saveMovie() {
        Movie movie = getMovie();
        //Mockito.when(actorRepository.save(Mockito.any())).thenReturn(actor);

        movieServiceImpl.saveMovie(movie);
        Mockito.verify(movieRepository).save(Mockito.any());

    }

    @Test
    void saveAllActors() {
        movieServiceImpl.saveAllMovies(getAllMovies());
        Mockito.verify(movieRepository).saveAll(Mockito.any());
    }

    @Test
    void deleteById() {
        movieServiceImpl.deleteById(1);
        Mockito.verify(movieRepository).deleteById(Mockito.anyLong());

    }

    List<Movie> getAllMovies(){
        List<Movie> movies = new ArrayList<>();
        Movie movie1 = new Movie();
        movie1.setName("test1");
        movie1.setDirector("Steve Schpeal");
        movie1.setBudget("4,000");
        movie1.setRuntime("200");
        movie1.setId(1L);
        Movie movie2 = new Movie();
        movie2.setName("test2");
        movie2.setDirector("Steve Schpeal");
        movie2.setBudget("8,000");
        movie2.setRuntime("120");
        movies.add(movie1);
        movies.add(movie2);
        return movies;
    }
    Movie getMovie(){
        Movie movie = new Movie();
        movie.setName("test1");
        movie.setDirector("Steve Schpeal");
        movie.setBudget("4,000");
        movie.setRuntime("200");
        movie.setId(1L);

        return movie;
    }
}
