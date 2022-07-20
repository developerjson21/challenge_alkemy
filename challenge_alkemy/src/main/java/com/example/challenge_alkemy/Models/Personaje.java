package com.example.challenge_alkemy.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "personajes")
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer edad;
    private Double peso;
    private String urlImg;
    private String historia;

    @ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL)
    private List<Pelicula> peliculas = new ArrayList<>();

    public Personaje(){};




}
