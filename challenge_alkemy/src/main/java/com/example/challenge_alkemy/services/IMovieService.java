package com.example.challenge_alkemy.services;
import com.example.challenge_alkemy.dto.MovieDTO;


import java.util.List;

public interface IMovieService {

    MovieDTO saveMovie(MovieDTO movieDTO);
    List<MovieDTO> getAll();
    MovieDTO findByName(String nombre);
    MovieDTO findById(Long id);
    void delete(Long id);
    MovieDTO update(Long id, MovieDTO movieDTO);
}
