package br.com.b2w.challenge.starwars.controller;

import br.com.b2w.challenge.starwars.model.dto.PlanetDTO;
import br.com.b2w.challenge.starwars.model.mapper.PlanetMapper;
import br.com.b2w.challenge.starwars.restclient.StarWarsAPIClient;
import br.com.b2w.challenge.starwars.service.interfaces.PlanetServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/starwars/planets")
public class StarWarsPlanetsController {

    @Autowired
    private PlanetServiceInterface planetService;

    @Autowired
    private StarWarsAPIClient swApiClient;

    @Autowired
    private PlanetMapper mapper;

    @GetMapping
    public ResponseEntity<List<PlanetDTO>> getAll() {

        return ResponseEntity.ok().body(mapper.mapAllToDTO(planetService.getAll()));
    }

    @PostMapping
    public ResponseEntity<PlanetDTO> add(@Valid @RequestBody PlanetDTO planet) {
        int numFilms = swApiClient.getTotalFilmsByPlanet(planet.getName());
        planet.setNumFilms(numFilms);

        PlanetDTO responsePlanet = mapper.map(planetService.add(mapper.map(planet)));

        UriComponents uriComponents = MvcUriComponentsBuilder.fromMethodName(
                StarWarsPlanetsController.class, "getById", responsePlanet.getId())
                .buildAndExpand(1);
        URI nextUri = uriComponents.toUri();
        return ResponseEntity.created(nextUri).body(responsePlanet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanetDTO> getById(@PathVariable long id) {

        return ResponseEntity.ok().body(mapper.map(planetService.getById(id)));
    }

    @GetMapping("/search")
    public ResponseEntity<List<PlanetDTO>> getByName(@RequestParam(required = true) String name) {

        return ResponseEntity.ok().body(mapper.mapAllToDTO(planetService.getByNameContaining(name)));
    }

    @PutMapping
    public ResponseEntity<PlanetDTO> updatePlanet(@Valid @RequestBody PlanetDTO planet) {
        int numFilms = swApiClient.getTotalFilmsByPlanet(planet.getName());
        planet.setNumFilms(numFilms);

        return ResponseEntity.ok().body(mapper.map(planetService.update(mapper.map(planet))));
    }

    @DeleteMapping("{id}")
    public ResponseEntity.HeadersBuilder<?> deletePlanet(@PathVariable long id) {

        planetService.remove(id);
        return ResponseEntity.status(HttpStatus.OK);
    }
}
