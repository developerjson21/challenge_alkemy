package com.example.challenge_alkemy.dto;

import com.example.challenge_alkemy.models.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class GenreDTO {

    private Long id;
    private String nombre;
    private String urlImg;
    private List<Movie> movies = new ArrayList<>();

}
