package com.example.sentiment_app.controller;

import com.example.sentiment_app.command.CreateTextDto;
import com.example.sentiment_app.command.CreateUserDto;
import com.example.sentiment_app.service.SentimentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class SentimentController {

    private SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @PostMapping ("/createUser")
    public ResponseEntity<?> createUser(@RequestBody CreateUserDto userDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream().map(e->e.getDefaultMessage()).toList();
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(sentimentService.createText(userDto), HttpStatus.CREATED);
    }

    @PostMapping ("/{id}/text")
    public ResponseEntity<?> createText(@PathVariable Integer id, @RequestBody CreateTextDto textDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream().map(e->e.getDefaultMessage()).toList();
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(sentimentService.createText(id, textDto), HttpStatus.OK);
    }








/*
















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
            String uri = "text-analysis12.p.rapidapi.com";
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

 */
}
