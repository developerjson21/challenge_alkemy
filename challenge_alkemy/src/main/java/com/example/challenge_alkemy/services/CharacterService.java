package com.example.challenge_alkemy.services;

import com.example.challenge_alkemy.dto.CharacterDTO;
import com.example.challenge_alkemy.dto.CharacterFiltersDTO;
import com.example.challenge_alkemy.mappers.CharacterMapper;
import com.example.challenge_alkemy.models.Character;
import com.example.challenge_alkemy.repositories.ICharacterRepository;
import com.example.challenge_alkemy.repositories.specifications.CharacterSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CharacterService implements ICharacterService {


    private ICharacterRepository characterRepository;
    private CharacterMapper characterMapper;
    private CharacterSpecification characterSpecification;

    @Autowired
    public CharacterService(ICharacterRepository characterRepository, CharacterMapper characterMapper, CharacterSpecification characterSpecification) {
        this.characterRepository = characterRepository;
        this.characterMapper = characterMapper;
        this.characterSpecification = characterSpecification;
    }

    @Override
    public CharacterDTO saveCharacter(CharacterDTO characterDTO) {
        Character character = characterMapper.converterToCharacter(characterDTO);
        Character characterSaved = characterRepository.save(character);
        CharacterDTO result = characterMapper.convertToCharacterDTO(characterSaved);
        return result;
    }

    @Override
    public CharacterDTO findByName(String name) {
        Character characterFound = characterRepository.findByNombre(name);
        CharacterDTO characterDTO = characterMapper.convertToCharacterDTO(characterFound);
        return characterDTO;
    }

    public CharacterDTO findByAge(Integer edad){
        Character characterFound = characterRepository.findByEdad(edad);
        CharacterDTO characterDTO = characterMapper.convertToCharacterDTO(characterFound);
        return characterDTO;

    }

    @Override
    public List<CharacterDTO> getAll() {
        List<Character> characters = characterRepository.findAll();
        List<CharacterDTO> charactersDTO = characterMapper.convertListToDTO(characters);
        return charactersDTO;
    }

    public List<CharacterDTO> getByFilters(String nombre, Integer edad, Set<Long> movies, String order){
        CharacterFiltersDTO filtersDTO = new CharacterFiltersDTO(nombre, edad, movies, order);
        List<Character> characters = characterRepository.findAll((Sort) characterSpecification.getByFilters(filtersDTO));
        List<CharacterDTO> characterDTOS = characterMapper.convertListToDTO(characters);
        return characterDTOS;
    }
    @Override
    public CharacterDTO findById(Long id) {
        // TODO: BUSCAR CHARACTER POR ID
        CharacterDTO characterDTO = null;
        try {
            Optional<Character>characterOptional = characterRepository.findById(id);
            if(characterOptional.isPresent()){
                Character character = characterMapper.convertOptionalToCharacter(characterOptional);
                characterDTO = characterMapper.convertToCharacterDTO(character);
                return characterDTO;
            }
        }catch (Exception e){
            System.out.println("NO FOUND CHARACTER! -> " + e.getMessage());
        }

        /*// ======= OPCION 2 - UTILIZANDO LA CLASE MODELMAPPER ============
        if(characterOptional.isPresent()){
            return modelMapper.map(characterOptional.get(), CharacterDTO.class);
        }*/
        // TODO: AGREGAR UNA EXCEPTION POR SI NO SE ENCUENTRA EL CHARACTER
        return characterDTO;
    }

    @Override
    public void delete(Long id) {
        characterRepository.deleteById(id);
    }

    @Override
    public CharacterDTO update(Long id, CharacterDTO characterDTO) {
        delete(id);
        characterDTO.setId(id);
        Character character = characterMapper.converterToCharacter(characterDTO);
        Character characterSaved = characterRepository.save(character);
        CharacterDTO result = characterMapper.convertToCharacterDTO(characterSaved);
        return result;
    }



}
