package com.example.challenge_alkemy.Services;


import com.example.challenge_alkemy.Models.PersonajeDTO;

public interface IPersonajeService {

    PersonajeDTO createPersonaje(PersonajeDTO personajeDTO);
    PersonajeDTO findByNombre(String nombre);
    PersonajeDTO findById(Integer id);
    void deletePersonaje(Integer id);
    PersonajeDTO updatePersonaje(Integer id, PersonajeDTO personajeDTO);

}
