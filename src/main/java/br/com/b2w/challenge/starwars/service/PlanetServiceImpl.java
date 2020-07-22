package br.com.b2w.challenge.starwars.service;

import br.com.b2w.challenge.starwars.controller.advice.ResourceNotFoundException;
import br.com.b2w.challenge.starwars.model.db.Planet;
import br.com.b2w.challenge.starwars.repository.PlanetRepository;
import br.com.b2w.challenge.starwars.service.interfaces.IdSequenceServiceInterface;
import br.com.b2w.challenge.starwars.service.interfaces.PlanetServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetServiceImpl implements PlanetServiceInterface {

    @Autowired
    private IdSequenceServiceInterface idSequenceService;

    @Autowired
    private PlanetRepository planetRepository;

    @Override
    public Planet add(Planet planet) {
        if(planetRepository.findByName(planet.getName()).isPresent()) {
            throw new RuntimeException("Planet already registered in the database.");
        }
        // depois de verificar se existe no banco de dados, verificar se existe na api
        // fazer isso consultando o numero de filmes que o planeta apareceu

        planet.setId(idSequenceService.getIdAndUpdate(Planet.SEQUENCE_NAME));
        return planetRepository.insert(planet);
    }

    @Override
    public void remove(long planetId) {
        planetRepository.deleteById(planetId);
    }

    @Override
    public Planet update(Planet planet) {
        return planetRepository.save(planet);
    }

    @Override
    public List<Planet> getByName(String planetName) {
        return planetRepository.findByNameContaining(planetName);
    }

    @Override
    public Planet getById(long id) {
        return planetRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found planet with id " + id));
    }

    @Override
    public List<Planet> getAll() {
        return planetRepository.findAll();
    }

}
