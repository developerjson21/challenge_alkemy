package com.example.challenge_alkemy.controllers;

import com.example.challenge_alkemy.dto.GenreDTO;
import com.example.challenge_alkemy.services.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private IGenreService genreService;

    @PostMapping()
    public ResponseEntity<GenreDTO> createGenre(@RequestBody GenreDTO genero){
        GenreDTO genreDTO = genreService.saveGenre(genero);
        System.out.println("CREANDO GENERO");
        return ResponseEntity.status(HttpStatus.CREATED).body(genreDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GenreDTO>> getAll(){
        return ResponseEntity.ok().body(genreService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreDTO> findById(@PathVariable Long id){
        GenreDTO foundGenre = genreService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(foundGenre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable Long id){
        genreService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("GENERO CON ID: " + id + " HA SIDO ELIMINADO");
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreDTO> update(@PathVariable Long id, @RequestBody GenreDTO genreDTO){
        GenreDTO genreDTOFound = genreService.update(id, genreDTO);
        return ResponseEntity.status(HttpStatus.OK).body(genreDTOFound);
    }
}
