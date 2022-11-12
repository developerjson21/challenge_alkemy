package com.example.challenge_alkemy.repositories;

import com.example.challenge_alkemy.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Long> {
}
