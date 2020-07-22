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

}
