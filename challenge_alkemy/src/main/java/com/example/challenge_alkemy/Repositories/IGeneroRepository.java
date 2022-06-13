package com.example.challenge_alkemy.Repositories;

import com.example.challenge_alkemy.Models.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGeneroRepository extends JpaRepository<Genero, Integer> {
}
