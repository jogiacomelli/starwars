package br.com.b2w.challenge.starwars.model.mapper;

import br.com.b2w.challenge.starwars.model.db.Planet;
import br.com.b2w.challenge.starwars.model.dto.PlanetDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlanetMapper {
    PlanetDTO map(Planet planet);
    Planet map(PlanetDTO planet);

    List<Planet> mapAllToPlanet(List<PlanetDTO> planets);
    List<PlanetDTO> mapAllToDTO(List<Planet> planets);

}
