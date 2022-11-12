package com.example.challenge_alkemy.repositories;

import com.example.challenge_alkemy.models.Character;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICharacterRepository extends JpaRepository<Character, Long> {

    // ? ES IMPORTANTE QUE LA PALABRA QUE ESTA DESPUES DE "findBy" SEA UN ATRIBUTO DE LA ENTIDAD "CHARACTER" PARA QUE JPAREPOSITORY PUEDA REALIZAR LA BUSQUEDA POR ESE ATRIBUTO
    Character findByNombre(String nombre);

    Character findByEdad(Integer edad);

    List<Character> findAll(Specification<Character> specification);
}
