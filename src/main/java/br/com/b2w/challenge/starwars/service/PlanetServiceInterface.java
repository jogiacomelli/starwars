package br.com.b2w.challenge.starwars.service;

import br.com.b2w.challenge.starwars.model.db.Planet;

import java.util.List;

public interface PlanetServiceInterface {

    Planet add(Planet planet);
    void remove(long planetId);
    List<Planet> getByName(String planetName);
    Planet getById(long id);

}
