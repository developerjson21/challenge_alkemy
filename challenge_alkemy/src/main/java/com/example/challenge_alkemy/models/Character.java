package com.example.challenge_alkemy.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer edad;
    private Double peso;
    private String urlImg;
    private String historia;

    public Character(){};


    @ManyToMany(mappedBy = "characters", cascade = CascadeType.ALL)
    private List<Movie> movies = new ArrayList<>();

    // ==================== METODOS =======================
    public void addMovie(Movie movie){
        this.movies.add(movie);
    }

    public void removeMovie(Movie movie){
        this.movies.remove(movie);
    }




}
