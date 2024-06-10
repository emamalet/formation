package fr.em.training.backend.pokemon.service;

import fr.em.training.backend.pokemon.mapper.PokemonMapper;
import fr.em.training.backend.pokemon.model.dto.PokemonDto;
import fr.em.training.backend.pokemon.model.entity.Pokemon;
import fr.em.training.backend.pokemon.repository.PokemonRepository;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

	private final PokemonRepository pokemonRepository;
	private final PokemonMapper pokemonMapper;

	public PokemonService(PokemonRepository pokemonRepository, PokemonMapper pokemonMapper) {
		this.pokemonRepository = pokemonRepository;
		this.pokemonMapper = pokemonMapper;
	}

	public void savePokmon(PokemonDto pokemonDto) {
		Pokemon pokemon = pokemonMapper.toEntity(pokemonDto);
		pokemonRepository.save(pokemon);
	}

}
