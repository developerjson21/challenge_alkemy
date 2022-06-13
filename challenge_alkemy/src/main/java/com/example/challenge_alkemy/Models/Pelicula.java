package com.example.challenge_alkemy.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private Date fechaCreacion;
    private String urlImg;
    private Integer calificacion; //1 a 5
    private List<Personaje> listPersonajes;

    public Pelicula(String titulo, Date fechaCreacion, String urlImg, Integer calificacion) {
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.urlImg = urlImg;
        this.calificacion = calificacion;
    }
}
