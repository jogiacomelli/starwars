package br.com.b2w.challenge.starwars.service.interfaces;

import br.com.b2w.challenge.starwars.model.db.Planet;

import java.util.List;

public interface PlanetServiceInterface {

    Planet add(Planet planet);
    boolean remove(long planetId);
    Planet update(Planet planet);
    List<Planet> getByNameContaining(String planetName);
    Planet getById(long id);
    List<Planet> getAll();

}
