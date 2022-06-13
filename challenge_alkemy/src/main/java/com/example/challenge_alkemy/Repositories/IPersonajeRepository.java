package com.example.challenge_alkemy.Repositories;

import com.example.challenge_alkemy.Models.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonajeRepository extends JpaRepository<Personaje, Integer> {


}
