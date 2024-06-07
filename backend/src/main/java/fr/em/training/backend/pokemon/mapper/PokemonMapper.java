package fr.em.training.backend.pokemon.mapper;

import fr.em.training.backend.pokemon.model.dto.PokemonDto;
import fr.em.training.backend.pokemon.model.entity.Pokemon;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PokemonMapper {

	Pokemon toEntity(PokemonDto pokemonDto);

}
