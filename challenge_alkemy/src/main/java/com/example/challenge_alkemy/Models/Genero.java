package com.example.challenge_alkemy.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String urlImg;
    private List<Pelicula> listPeliculas;

    public Genero(){};
    public Genero(String nombre, String urlImg) {
        this.nombre = nombre;
        this.urlImg = urlImg;
    }

}
