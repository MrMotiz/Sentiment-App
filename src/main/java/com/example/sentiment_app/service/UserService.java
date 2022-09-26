package com.example.sentiment_app.service;

import com.example.sentiment_app.command.CreateTextDto;
import com.example.sentiment_app.command.CreateUserDto;
import com.example.sentiment_app.command.TextDto;
import com.example.sentiment_app.command.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getUserList();

    UserDto getUserById(Integer id);

    UserDto addUser(CreateUserDto createUser);

    TextDto addTextToUser(CreateUserDto createUser, Integer id);

    TextDto addTextToUser(CreateTextDto createTextDto, Integer id);

    void deleteUserList();

    void deleteTextById(Integer textId);


}
