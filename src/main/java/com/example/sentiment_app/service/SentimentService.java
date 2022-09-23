package com.example.sentiment_app.service;

import com.example.sentiment_app.command.CreateTextDto;
import com.example.sentiment_app.repository.UserRepository;

import java.net.URI;
import java.net.http.HttpRequest;

public class SentimentService {


    private UserRepository userRepository;

    private TextService textService;



    public TextDto createText(Integer id, CreateTextDto textDto){
        textDto.setUser(userRepository.findById(id).orElseThrow());
        return textService.createText(textDto);

    }


}
