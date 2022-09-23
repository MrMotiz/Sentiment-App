package com.example.sentiment_app.service;

public class SentimentService {


    private SentimentRepository serviceRepository;

    private UserService userService;



    public TextDto createText(CreateTextDto textDto){
        Text text = TextConverter.convertCreateTExtDtoToEntity(textDto);


    }
}
