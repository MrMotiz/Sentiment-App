package com.example.sentiment_app.service;

import com.example.sentiment_app.command.*;
import com.example.sentiment_app.exceptions.ResourceNotFoundException;
import com.example.sentiment_app.model.User;
import com.example.sentiment_app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private TextServiceImpl textServiceImpl;

    public UserServiceImpl(UserRepository userRepository, TextServiceImpl textServiceImpl) {
        this.userRepository = userRepository;
        this.textServiceImpl = textServiceImpl;
    }

    @Override
    public List<UserDto> getUserList() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> UserConverter.convertToDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("The user " + id + " does not exist"));
        return UserConverter.convertToDto(user);
    }

    @Override
    public UserDto createUser(CreateUserDto createUserDto) {
        User user = UserConverter.convertCreateUserDtoToEntity(createUserDto);
        user = userRepository.save(user);
        return UserConverter.convertToDto(user);
    }

    @Override
    public TextDto createText(Integer id, CreateTextDto textDto) {
        textDto.setUser(userRepository.findById(id).orElseThrow());
        return textServiceImpl.createText(textDto);
    }

    @Override
    public List<TextDto> findAllTexts(Integer id) {

        User user = userRepository.findById(id).orElseThrow();
        return textServiceImpl.findAllTexts(user);
    }

    @Override
    public UserDto findSpecificUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow();
        return UserConverter.convertToDtoWithSentence(user);

    }
}