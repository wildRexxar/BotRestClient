package com.example.botrestclient.entity;

import java.util.Objects;

public class City {

    private int id;

    private String title;

    private String attraction;

    public City() {
    }

    public City(String title, String attraction) {
        this.title = title;
        this.attraction = attraction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAttraction() {
        return attraction;
    }

    public void setAttraction(String attraction) {
        this.attraction = attraction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id && Objects.equals(title, city.title) && Objects.equals(attraction, city.attraction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, attraction);
    }
}
