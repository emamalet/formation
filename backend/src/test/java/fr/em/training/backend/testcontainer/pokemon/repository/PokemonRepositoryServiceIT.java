package fr.em.training.backend.testcontainer.pokemon.repository;

import fr.em.training.backend.pokemon.model.entity.Pokemon;
import fr.em.training.backend.pokemon.repository.PokemonRepository;
import fr.em.training.backend.testcontainer.configuration.AbstractIntegrationTest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PokemonRepositoryServiceIT extends AbstractIntegrationTest {

	public static final String PLANTE = "Plante";
	public static final String FEU = "Feu";
	public static final String EMPTY = "";

	@Autowired
	PokemonRepository pokemonRepository;

	@BeforeEach
	void setUp() {
		pokemonRepository.deleteAll();
	}

	@Test
	@Transactional
	void shouldFindPokemonsByType1() {
		pokemonRepository.save(createPokemon("Bulbizarre", PLANTE, EMPTY));
		pokemonRepository.save(createPokemon("Herbizarre", PLANTE, "Poison"));
		pokemonRepository.save(createPokemon("Florizarre", PLANTE, "Poison"));
		pokemonRepository.save(createPokemon("Salamèche", FEU, EMPTY));
		pokemonRepository.save(createPokemon("Reptincel", FEU, EMPTY));
		pokemonRepository.save(createPokemon("Dracaufeu", FEU, "Vol"));
		List<Pokemon> pokemons = pokemonRepository.findByType1(PLANTE);
		assertEquals(3, pokemons.size());
	}

	private Pokemon createPokemon(String name, String type1, String type2) {
		Pokemon pokemon = new Pokemon();
		pokemon.setName(name);
		pokemon.setType1(type1);
		pokemon.setType2(type2);
		return pokemon;
	}

}