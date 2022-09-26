package com.example.sentiment_app.service;

import com.example.sentiment_app.command.CreateTextDto;
import com.example.sentiment_app.command.TextDto;
import com.example.sentiment_app.repository.UserRepository;

public class UserServiceImpl {


    private UserRepository userRepository;

    private TextServiceImpl textServiceImpl;



    public TextDto createText(Integer id, CreateTextDto textDto){
        textDto.setUser(userRepository.findById(id).orElseThrow());
        return textServiceImpl.createText(textDto);

    }


}
