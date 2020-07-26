package br.com.b2w.challenge.starwars.restclient;

import br.com.b2w.challenge.starwars.controller.advice.ResourceNotFoundException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StarWarsAPIClient {

    @Value("${starwars.host.search}")
    String hostSearch;

    RestTemplate restTemplate;

    public StarWarsAPIClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public int getTotalFilmsByPlanet(String planetName) {
        int numFilmes = 0;

        ResponseEntity<String> response = restTemplate.getForEntity(hostSearch + planetName, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            Gson gson = new Gson();

            JsonArray resultArray = gson.fromJson(response.getBody(), JsonObject.class)
                    .get("results")
                    .getAsJsonArray();

            if(resultArray.size() == 1) {
                numFilmes = resultArray.get(0).getAsJsonObject().get("films").getAsJsonArray().size();
            } else {
                throw new ResourceNotFoundException("Found in the star wars universe the planet " + planetName + " was not. Yrsssss.");
            }
        }

        return numFilmes;
    }
}
