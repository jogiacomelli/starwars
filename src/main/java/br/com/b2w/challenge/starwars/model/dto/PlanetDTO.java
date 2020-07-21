package br.com.b2w.challenge.starwars.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class PlanetDTO implements Serializable {

    private long id;
    private String name;
    private String climate;
    private String terrain;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanetDTO planetDTO = (PlanetDTO) o;
        return getId() == planetDTO.getId() &&
                getName().equals(planetDTO.getName()) &&
                getClimate().equals(planetDTO.getClimate()) &&
                getTerrain().equals(planetDTO.getTerrain());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getClimate(), getTerrain());
    }

    @Override
    public String toString() {
        return "PlanetDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", climate='" + climate + '\'' +
                ", terrain='" + terrain + '\'' +
                '}';
    }
}
