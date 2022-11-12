package com.example.challenge_alkemy.mappers;

import com.example.challenge_alkemy.dto.MovieDTO;
import com.example.challenge_alkemy.models.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public Movie converterToMovie(MovieDTO movieDTO){
        Movie movie = new Movie();
        movie.setTitulo(movieDTO.getTitulo());
        movie.setCalificacion(movie.getCalificacion());
        movie.setUrlImg(movieDTO.getUrlImg());
        movie.setGenreId(movieDTO.getGeneroId());
        movie.setFechaCreacion(movieDTO.getFechaCreacion());

        return movie;
    }

    public MovieDTO converterToMovieDTO(Movie movie){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setTitulo(movie.getTitulo());
        movieDTO.setCalificacion(movie.getCalificacion());
        movieDTO.setUrlImg(movie.getUrlImg());
        movieDTO.setGeneroId(movie.getId());
        movieDTO.setFechaCreacion(movie.getFechaCreacion());
        return movieDTO;
    }

}
