package com.example.botrestclient;

import com.example.botrestclient.entity.City;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    private final RestTemplate restTemplate;
    private String URL = "http://localhost:8080/api/cities";

    public Communication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<City> cityList() {
        ResponseEntity<List<City>> responseEntity
                = restTemplate.exchange(URL,
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<City>>() {
        });
        return responseEntity.getBody();
    }

    public City getCity(String city) {
        return restTemplate.getForObject(URL + "/" + city, City.class);
    }

    public void addCity(City city) {
        int id = city.getId();
        if(id == 0) {
            ResponseEntity<String> responseEntity =
                    restTemplate.postForEntity(URL, city, String.class);
            System.out.println("New city was added to DB");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, city);
            System.out.println("City with ID " + id + " was updated");
        }
    }

    public void deleteCity(String city) {
        restTemplate.delete(URL + "/" + city);
        System.out.println("City : " + city + " was deleted from DB");
    }
}
