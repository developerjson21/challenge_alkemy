package com.example.challenge_alkemy.dto;

import com.example.challenge_alkemy.models.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class CharacterDTO {

    private Long id;
    private String nombre;
    private Integer edad;
    private Double peso;
    private String urlImg;
    private String historia;
    private List<Movie> movies = new ArrayList<>();
}
