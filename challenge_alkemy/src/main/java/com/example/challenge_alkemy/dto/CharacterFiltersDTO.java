package com.example.challenge_alkemy.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class CharacterFiltersDTO {

    private String nombre;
    private Integer edad;
    private Set<Long> movies;
    private String order;

    public CharacterFiltersDTO(String nombre, Integer edad, Set<Long> movies, String order) {
        this.nombre = nombre;
        this.edad = edad;
        this.movies = movies;
        this.order = order;
    }

    public boolean isASC(){
        return order.compareToIgnoreCase("ASC") == 0;
    }

    public boolean isDESC(){
        return order.compareToIgnoreCase("DESC") == 0;
    }
}
