package fr.em.training.backend.testcontainer.pokemon.service;

import fr.em.training.backend.pokemon.model.dto.PokemonDto;
import fr.em.training.backend.pokemon.model.entity.Pokemon;
import fr.em.training.backend.pokemon.repository.PokemonRepository;
import fr.em.training.backend.pokemon.service.PokemonService;
import fr.em.training.backend.testcontainer.configuration.AbstractIntegrationTest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PokemonServiceIT extends AbstractIntegrationTest {

	@Autowired
	PokemonService pokemonService;

	@Autowired
	PokemonRepository pokemonRepository;

	@BeforeEach
	void setUp() {
		pokemonRepository.deleteAll();
	}

	@Test
	@Transactional
	void shouldSavePokemon() {
		pokemonService.savePokmon(createPokemonDto("Arceus", "Normal", ""));
		List<Pokemon> pokemons = pokemonRepository.findAll();
		assertEquals(1, pokemons.size());
	}

	@Test
	@Transactional
	void shouldFindAllPokemons() {
		pokemonService.savePokmon(createPokemonDto("Bulbizarre", "Plante", ""));
		pokemonService.savePokmon(createPokemonDto("Herbizarre", "Plante", "Poison"));
		pokemonService.savePokmon(createPokemonDto("Florizarre", "Plante", "Poison"));
		List<Pokemon> pokemons = pokemonRepository.findAll();
		assertEquals(3, pokemons.size());
	}

	private PokemonDto createPokemonDto(String name, String type1, String type2) {
		PokemonDto pokemonDto = new PokemonDto();
		pokemonDto.setName(name);
		pokemonDto.setType1(type1);
		pokemonDto.setType2(type2);
		return pokemonDto;
	}

}