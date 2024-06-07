package fr.em.training.backend.pokemon.repository;

import fr.em.training.backend.pokemon.model.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

	List<Pokemon> findByType1(String type1);

}
