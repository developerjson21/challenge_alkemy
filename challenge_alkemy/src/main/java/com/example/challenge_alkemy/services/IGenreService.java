package com.example.challenge_alkemy.services;


import com.example.challenge_alkemy.dto.GenreDTO;

import java.util.List;

public interface IGenreService {

    GenreDTO saveGenre(GenreDTO genreDTO);
    List<GenreDTO> getAll();
    GenreDTO findByName(String nombre);
    GenreDTO findById(Long id);
    void delete(Long id);
    GenreDTO update(Long id, GenreDTO genreDTO);
}
