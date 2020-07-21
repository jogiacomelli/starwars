package br.com.b2w.challenge.starwars.repository;

import br.com.b2w.challenge.starwars.model.db.Planet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface  PlanetRepository extends MongoRepository<Planet, Long> {

    List<Planet> findByNameContaining(String name);

}
