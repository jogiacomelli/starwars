package br.com.b2w.challenge.starwars.controller;

import br.com.b2w.challenge.starwars.model.dto.PlanetDTO;
import br.com.b2w.challenge.starwars.model.mapper.PlanetMapper;
import br.com.b2w.challenge.starwars.service.interfaces.PlanetServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/starwars/planets")
public class StarWarsPlanetsController {

    @Autowired
    private PlanetServiceInterface planetService;

    @Autowired
    private PlanetMapper mapper;

    @GetMapping
    public ResponseEntity<List<PlanetDTO>> getAll() {

        return ResponseEntity.ok().body(mapper.mapAllToDTO(planetService.getAll()));
    }

    @PostMapping
    public ResponseEntity<PlanetDTO> add(@RequestBody PlanetDTO planet) {
        PlanetDTO responsePlanet = mapper.map(planetService.add(mapper.map(planet)));

        return  ResponseEntity.ok().body(responsePlanet);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PlanetDTO> getById(@PathVariable long id) {

        return ResponseEntity.ok().body(mapper.map(planetService.getById(id)));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<PlanetDTO>> getByName(@PathVariable String name) {

        return ResponseEntity.ok().body(mapper.mapAllToDTO(planetService.getByNameContaining(name)));
    }

    @PutMapping
    public ResponseEntity<PlanetDTO> updatePlanet(@RequestBody PlanetDTO planet) {

        return ResponseEntity.ok().body(mapper.map(planetService.update(mapper.map(planet))));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deletePlanet(@PathVariable long id) {

        return ResponseEntity.ok().body(planetService.remove(id));
    }
}
