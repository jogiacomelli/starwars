package br.com.b2w.challenge.starwars.service;

import br.com.b2w.challenge.starwars.model.db.Planet;
import br.com.b2w.challenge.starwars.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlanetServiceImpl implements PlanetServiceInterface {

    @Autowired
    private PlanetRepository planetRepository;

    @Override
    public Planet add(Planet planet) {
        return planetRepository.insert(planet);
    }

    @Override
    public void remove(long planetId) {
        planetRepository.deleteById(planetId);
    }

    @Override
    public List<Planet> getByName(String planetName) {
        return planetRepository.findByNameContaining(planetName);
    }

    @Override
    public Planet getById(long id) {
        return planetRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found planet with id " + id));
    }

}
