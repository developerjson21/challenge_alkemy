package com.example.challenge_alkemy.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String urlImg;
    private Integer calificacion; //1 a 5

    public Movie() {
    }

    // ======================= CONSTRUCTOR ============================
    public Movie(String titulo, Date fechaCreacion, String urlImg, Integer calificacion) {
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.urlImg = urlImg;
        this.calificacion = calificacion;
    }

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id", insertable = false, updatable = false)
    private Genre genre;

    @Column(name = "genre_id", nullable = false)
    private Long genreId;


    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable( // DEFINE LA TABLA INTERMEDIA NECESARIA PARA LA RELACION "MANY TO MANY"
            name = "character_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id"))
    private Set<Character> characters = new HashSet<>();



    // ========================= EQUALS ==========================
    @Override
    public boolean equals(Object o) {
        if(o == null){
            return false;
        }
        if(getClass() != o.getClass()){
            return false;
        }
        final Movie other = (Movie) o;

        return Objects.equals(other.id, this.id);
    }

}
