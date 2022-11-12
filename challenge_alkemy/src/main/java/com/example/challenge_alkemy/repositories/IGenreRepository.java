package com.example.challenge_alkemy.repositories;

import com.example.challenge_alkemy.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenreRepository extends JpaRepository<Genre, Long> {
}
