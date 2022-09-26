package com.example.sentiment_app.service;

import com.example.sentiment_app.command.*;
import com.example.sentiment_app.model.Text;
import com.example.sentiment_app.model.User;
import com.example.sentiment_app.repository.UserRepositoryJpa;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImp implements UserService{


    private UserRepositoryJpa userRepository;

    private TextService textService;


/*
    public TextDto createText(Integer id, CreateTextDto textDto){
        textDto.setUser(userRepository.findById(id).orElseThrow());
        return textService.createText(textDto);

    }*/


    @Override
    public List<UserDto> getUserList() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> UserConverter.convertToDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The user " + id + " does not exist"));
        return UserConverter.convertToDto(user);
    }

    @Override
    public UserDto addUser(CreateUserDto createUserDto) {
        User user = UserConverter.convertCreateUserDtoToEntity(createUserDto);
        userRepository.save(user);
        return UserConverter.convertToDto(user);
    }

    @Override
    public TextDto addTextToUser(CreateTextDto createTextDto, Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User " + id + " not found. Can't add text to User"));

        Text text = TextConverter.convertCreateTextDtoToEntity(createTextDto);

        textService.addTextToUser(text, user);
        return TextConverter.convertToDto(text);
    }

    @Override
    public void deleteUserList() {
        userRepository.deleteAll();

    }

    @Override
    public void deleteTextById(Integer textId) {
        textService.deleteTextById(textId);

    }
}
