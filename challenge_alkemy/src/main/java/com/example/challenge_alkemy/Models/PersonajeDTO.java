package com.example.challenge_alkemy.Models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonajeDTO {
    private Integer id;
    private String nombre;
    private Integer edad;
    private Double peso;
    private String urlImg;
    private String historia;
}
