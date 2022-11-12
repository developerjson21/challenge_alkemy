package com.example.challenge_alkemy.controllers;

import com.example.challenge_alkemy.dto.GenreDTO;
import com.example.challenge_alkemy.dto.MovieDTO;
import com.example.challenge_alkemy.services.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @PostMapping
    public ResponseEntity<MovieDTO> createMovie(@RequestParam MovieDTO movie){
        MovieDTO movieDTO = movieService.saveMovie(movie);
        return new ResponseEntity<>(movieDTO, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieDTO>> getAll(){
        return ResponseEntity.ok().body(movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable Long id){
        MovieDTO foundMovie = movieService.findById(id);
        return new ResponseEntity<>(foundMovie, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable Long id){
        movieService.delete(id);
        return new ResponseEntity<>("MOVIE CON ID: " + id + " HA SIDO ELIMINADO", HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> update(@PathVariable Long id, @RequestBody MovieDTO movie){
        MovieDTO movieDTOFound = movieService.update(id, movie);
        return ResponseEntity.status(HttpStatus.OK).body(movieDTOFound);
    }


}
