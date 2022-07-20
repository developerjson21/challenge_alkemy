package com.example.challenge_alkemy.Services;

import com.example.challenge_alkemy.Models.Personaje;
import com.example.challenge_alkemy.Models.PersonajeDTO;
import com.example.challenge_alkemy.Repositories.IPersonajeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PersonajeService implements IPersonajeService{

    IPersonajeRepository personajeRepository;

    ModelMapper modelMapper;

    @Override
    public PersonajeDTO createPersonaje(PersonajeDTO personajeDTO) {
        return null;
    }

    @Override
    public PersonajeDTO findByNombre(String nombre) {
        return null;
    }

    @Override
    public PersonajeDTO findById(Integer id) {
        return null;
    }

    @Override
    public void deletePersonaje(Integer id) {

    }

    @Override
    public PersonajeDTO updatePersonaje(Integer id, PersonajeDTO personajeDTO) {
        return null;
    }
}
