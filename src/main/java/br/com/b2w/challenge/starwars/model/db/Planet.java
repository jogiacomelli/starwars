package br.com.b2w.challenge.starwars.model.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "planets")
public class Planet {
    @Transient
    public static final String SEQUENCE_NAME = "planets_id_sequence";

    @Id
    private long id;

    private String name;
    private String climate;
    private String terrain;
    private int numFilms;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public int getNumFilms() {
        return numFilms;
    }

    public void setNumFilms(int numFilms) {
        this.numFilms = numFilms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return getId() == planet.getId() &&
                getNumFilms() == planet.getNumFilms() &&
                getName().equals(planet.getName()) &&
                getClimate().equals(planet.getClimate()) &&
                getTerrain().equals(planet.getTerrain());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getClimate(), getTerrain(), getNumFilms());
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", climate='" + climate + '\'' +
                ", terrain='" + terrain + '\'' +
                ", numFilms=" + numFilms +
                '}';
    }
}
