package com.example.challenge_alkemy.Repositories;

import com.example.challenge_alkemy.Models.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeliculaRepository extends JpaRepository<Pelicula, Integer> {
}
