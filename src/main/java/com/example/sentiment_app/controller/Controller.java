package com.example.sentiment_app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World1";
    }

    @GetMapping(value = "/callclienthello")
    private String getHelloClient(){
        String uri = "http://localhost:8080/hello";
        RestTemplate template = new RestTemplate();
        String result = template.getForObject(uri, String.class);
        return result;
    }

    @GetMapping(value = "/countries")
    public ResponseEntity<?> getCountries() {
        try {
            String uri = "https://countriesnow.space/api/v0.1/countries";
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(uri, String.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @GetMapping(value = "/londonWeather")
    public ResponseEntity<?> getLondonWeather() {
        try {
            String uri = "https://alpha-meme-maker.herokuapp.com";
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(uri, String.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
    } catch (Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>("Error!, Please try again", HttpStatus.BAD_REQUEST);}
    }
}
