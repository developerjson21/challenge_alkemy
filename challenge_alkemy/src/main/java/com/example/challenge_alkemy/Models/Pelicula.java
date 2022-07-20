package com.example.challenge_alkemy.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date fechaCreacion;
    private String urlImg;
    private Integer calificacion; //1 a 5

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "genero_id", insertable = false, updatable = false)
    private Genero genero;

    @Column(name = "genero_id", nullable = false)
    private Long generoId;


    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable( // DEFINE LA TABLA INTERMEDIA NECESARIA PARA LA RELACION "MANY TO MANY"
            name = "personaje_pelicula",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id"))
    private Set<Personaje> personajes = new HashSet<>();


    // ======================= CONSTRUCTOR ============================
    public Pelicula(String titulo, Date fechaCreacion, String urlImg, Integer calificacion) {
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.urlImg = urlImg;
        this.calificacion = calificacion;
    }

    // ========================= EQUALS ==========================
    @Override
    public boolean equals(Object o) {
        if(o == null){
            return false;
        }
        if(getClass() != o.getClass()){
            return false;
        }
        final Pelicula other = (Pelicula) o;
        return other.id == this.id;
    }

}
