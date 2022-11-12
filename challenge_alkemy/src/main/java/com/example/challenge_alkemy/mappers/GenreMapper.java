package com.example.challenge_alkemy.mappers;

import com.example.challenge_alkemy.dto.GenreDTO;
import com.example.challenge_alkemy.models.Genre;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GenreMapper {

    public Genre converterToGenero(GenreDTO genreDTO){
        Genre genre1 = new Genre();
        genre1.setNombre(genreDTO.getNombre());
        genre1.setUrlImg(genreDTO.getUrlImg());
        return genre1;
    }

    public GenreDTO converterToGeneroDTO(Genre genre){
        GenreDTO genreDTO =new GenreDTO();
        genreDTO.setId(genre.getId());
        genreDTO.setNombre(genre.getNombre());
        genreDTO.setUrlImg(genre.getUrlImg());
        return genreDTO;
    }

    // ============= FUNCION PARA CONVERTIR LIST<GENRE> A LIST<GENREDTO> =====================
    public List<GenreDTO> convertListToDTO(List<Genre> genres){
        List<GenreDTO> genreDTO = new ArrayList<>();
        for ( Genre genre : genres) {
            genreDTO.add(converterToGeneroDTO(genre));
        }
        return genreDTO;
    }
    // ============ FUNCION PARA CONVERTIR OBJETOS "OPTIONAL" QUE LLEGAN DEL REPOSITORY -> GENRE  =========================
    public Genre convertOptionalToGenre(Optional<Genre> genreOptional){
        Genre genre = new Genre();
        genre.setId(genreOptional.get().getId());
        genre.setNombre(genreOptional.get().getNombre());
        genre.setUrlImg(genreOptional.get().getUrlImg());

        return genre;
    }



}
