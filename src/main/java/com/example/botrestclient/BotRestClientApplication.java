package com.example.botrestclient;

import com.example.botrestclient.config.MyConfig;
import com.example.botrestclient.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.util.List;


public class BotRestClientApplication {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

        List<City> cities = communication.cityList();
        System.out.println(cities);

        City city = communication.getCity("City");
        System.out.println(city);

        City newCity = new City("London", "Take a ride on the eye of London");
//        newCity.setId(3);
        communication.addCity(newCity);

//        communication.deleteCity("London");
    }
}
