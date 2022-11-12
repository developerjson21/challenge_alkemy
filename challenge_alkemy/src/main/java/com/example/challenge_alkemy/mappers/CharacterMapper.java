package com.example.challenge_alkemy.mappers;


import com.example.challenge_alkemy.dto.CharacterDTO;
import com.example.challenge_alkemy.dto.MovieDTO;
import com.example.challenge_alkemy.models.Character;
import com.example.challenge_alkemy.models.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CharacterMapper {

    public Character converterToCharacter(CharacterDTO characterDTO){
        Character character = new Character();
        character.setNombre(characterDTO.getNombre());
        character.setEdad(characterDTO.getEdad());
        character.setHistoria(characterDTO.getHistoria());
        character.setPeso(characterDTO.getPeso());
        character.setUrlImg(characterDTO.getUrlImg());

        return character;
    }

    public CharacterDTO convertToCharacterDTO(Character character){
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setId(character.getId());
        characterDTO.setNombre(character.getNombre());
        characterDTO.setEdad(character.getEdad());
        characterDTO.setPeso(character.getPeso());
        characterDTO.setUrlImg(character.getUrlImg());
        characterDTO.setHistoria(character.getHistoria());

        return characterDTO;
    }
    // ============ FUNCION PARA CONVERIR LIST<CHARACTER> -> LIST<CHARACTERDTO>
    public List<CharacterDTO> convertListToDTO(List<Character> characterList){
        List<CharacterDTO> charactersDTO = new ArrayList<>();
        for(Character character : characterList){
            charactersDTO.add(convertToCharacterDTO(character));
        }
        return charactersDTO;
    }
    // ============ FUNCION PARA CONVERTIR OBJETOS "OPTIONAL" QUE LLEGAN DEL REPOSITORY -> CHARACTER  =========================
    public Character convertOptionalToCharacter(Optional<Character> characterOptional){
        Character character = new Character();
        character.setNombre(characterOptional.get().getNombre());
        character.setPeso(characterOptional.get().getPeso());
        character.setEdad(characterOptional.get().getEdad());
        character.setUrlImg(characterOptional.get().getUrlImg());
        character.setHistoria(characterOptional.get().getHistoria());
        return character;
    }

}
