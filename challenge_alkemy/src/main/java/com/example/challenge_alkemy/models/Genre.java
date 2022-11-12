package com.example.challenge_alkemy.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "genres")
public class Genre {

    // @Column -> Se utiliza cuando mi columna en mi base de datos tiene un nombre diferente a mi atributo en este caso id.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String urlImg;

        @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "pelicula_id")
    private Movie pelicula; 

}
