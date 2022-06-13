package com.example.challenge_alkemy.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Integer edad;
    private Double peso;
    private String urlImg;
    private String historia;
    private List<Pelicula> listPeliculas;

    public Personaje(){};
    public Personaje(String nombre, Integer edad, Double peso, String urlImg, String historia) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.urlImg = urlImg;
        this.historia = historia;
    }
}
