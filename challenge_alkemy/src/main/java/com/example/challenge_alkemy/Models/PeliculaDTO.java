package com.example.challenge_alkemy.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PeliculaDTO {
    private Integer id;
    private String titulo;
    private Date fechaCreacion;
    private String urlImg;
    private Integer calificacion;
}
