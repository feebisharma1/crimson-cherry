package com.allstate.crimsoncherry.service;

import com.allstate.crimsoncherry.entity.Movie;
import com.allstate.crimsoncherry.repository.ActorRepository;
import com.allstate.crimsoncherry.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = {NullPointerException.class})
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies(){
      return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findMoviesById(long id){
        return movieRepository.findById(id);
    }

    @Override
   public void saveMovie(Movie movie){
        movieRepository.save(movie);
    }

    public void saveAllMovies(List<Movie> movies){
        movieRepository.saveAll(movies);
    }

   public List<Movie> findMoviesByDirector(String director){
        return movieRepository.findAllByDirector(director);
   }

    public void deleteById(long id){
        movieRepository.deleteById(id);
    }
}
