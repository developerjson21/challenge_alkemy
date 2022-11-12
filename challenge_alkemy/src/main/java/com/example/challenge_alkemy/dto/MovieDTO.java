package com.example.challenge_alkemy.dto;

import com.example.challenge_alkemy.models.Character;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class MovieDTO {

    private Long id;
    private String titulo;
    private Date fechaCreacion;
    private String urlImg;
    private Integer calificacion;
    private Long generoId;

    private List<Character> characters = new ArrayList<>();
}
