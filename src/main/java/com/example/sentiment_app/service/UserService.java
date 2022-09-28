package com.example.sentiment_app.service;

import com.example.sentiment_app.command.CreateTextDto;
import com.example.sentiment_app.command.CreateUserDto;
import com.example.sentiment_app.command.TextDto;
import com.example.sentiment_app.command.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getUserList();

    UserDto getUserById(Integer id);

    UserDto createUser(CreateUserDto createUser);


    TextDto createText(Integer id, CreateTextDto textDto);

    UserDto findSpecificUser(Integer id);
    List<TextDto> findAllTexts(Integer id);


}
