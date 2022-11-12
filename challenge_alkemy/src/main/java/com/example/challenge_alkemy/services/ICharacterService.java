package com.example.challenge_alkemy.services;


import com.example.challenge_alkemy.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {

    CharacterDTO saveCharacter(CharacterDTO characterDTO);
    CharacterDTO findByName(String nombre);
    List<CharacterDTO> getAll();
    CharacterDTO findById(Long id);
    void delete(Long id);
    CharacterDTO update(Long id, CharacterDTO characterDTO);

}
