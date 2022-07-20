package com.example.challenge_alkemy.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "generos")
public class Genero {

    // @Column -> Se utiliza cuando mi columna en mi base de datos tiene un nombre diferente a mi atributo en este caso id.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String urlImg;

    private List<Pelicula> listPeliculas;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;

    public Genero(){};

    public Genero(String nombre, String urlImg, List<Pelicula> listPeliculas) {
        this.nombre = nombre;
        this.urlImg = urlImg;
        this.listPeliculas = listPeliculas;
    }
}
