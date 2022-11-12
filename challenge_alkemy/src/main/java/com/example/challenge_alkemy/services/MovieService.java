package com.example.challenge_alkemy.services;

import com.example.challenge_alkemy.dto.MovieDTO;
import com.example.challenge_alkemy.mappers.MovieMapper;
import com.example.challenge_alkemy.models.Movie;
import com.example.challenge_alkemy.repositories.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    @Autowired
    IMovieRepository movieRepository;

    @Autowired
    MovieMapper movieMapper;


    @Override
    public MovieDTO saveMovie(MovieDTO movieDTO) {
        Movie movie = movieMapper.converterToMovie(movieDTO);
        Movie movieSaved = movieRepository.save(movie);

        return null;
    }

    @Override
    public List<MovieDTO> getAll() {
        return null;
    }

    @Override
    public MovieDTO findByName(String nombre) {
        return null;
    }

    @Override
    public MovieDTO findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public MovieDTO update(Long id, MovieDTO movieDTO) {
        return null;
    }
}
