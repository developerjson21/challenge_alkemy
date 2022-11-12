package com.example.challenge_alkemy.controllers;

import com.example.challenge_alkemy.dto.CharacterDTO;
import com.example.challenge_alkemy.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping("/all")
    public ResponseEntity<List<CharacterDTO>> findAll(){
        List<CharacterDTO> characters = characterService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(characters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> findById(@PathVariable Long id){
        CharacterDTO characterDTO = characterService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(characterDTO);
    }


    @PostMapping()
    public ResponseEntity<CharacterDTO> createCharacter(@RequestBody CharacterDTO characterDTO){
        CharacterDTO createdCharacter = characterService.saveCharacter(characterDTO);
        return ResponseEntity.status(HttpStatus.OK).body(createdCharacter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable Long id){
        characterService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("CHARACTER CON ID: " + id + " HA SIDO ELIMINADO");
    }
    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> updateCharacter(@PathVariable Long id, @RequestBody CharacterDTO characterDTO){
        CharacterDTO result = characterService.update(id, characterDTO);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping()
    public ResponseEntity<CharacterDTO> findByName(@RequestParam String name){
        CharacterDTO result = characterService.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    /**
     *  TODO: HAY UN PROBLEMA DE AMBIGUEDAD DE PATH ENTRE LOS METODOS findByName and findByAge
    *   BUSCAR COMO PUEDO HACER DISTINTOS REQUEST A UN MISMO ENDPOINT
    **/

    @GetMapping()
    public ResponseEntity<CharacterDTO> findByAge(@RequestParam Integer edad){
        CharacterDTO result = characterService.findByAge(edad);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
