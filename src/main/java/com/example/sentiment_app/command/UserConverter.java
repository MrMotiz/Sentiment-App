package com.example.sentiment_app.command;

import com.example.sentiment_app.model.User;

public class UserConverter {

    public static UserDto convertToDto(User user) {
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .city(user.getCity())
                .gender(user.getGender())
                //.sentence(user.getSentence().stream().map(TextConverter::convertToDto).toList())
                .build();
    }


    public static User convertUserDtoToEntity(UserDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .age(userDto.getAge())
                .city(userDto.getCity())
                .gender(userDto.getGender())
                //.sentences(userDto.getSentences().stream().map(TextConverter::convertTextToDtoToEntity).toList())
                .build();
    }

    public static User convertCreateUserDtoToEntity(CreateUserDto createUserDto) {
        return User.builder()
                .firstName(createUserDto.getFirstName())
                .lastName(createUserDto.getLastName())
                .age(createUserDto.getAge())
                .city(createUserDto.getCity())
                .gender(createUserDto.getGender())
                .sentence(createUserDto.getSentence())
                .build();

    }

    public static UserDto convertToDtoWithSentence(User user){
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .city(user.getCity())
                .gender(user.getGender())
                .sentence(user.getSentence().stream().map(e-> TextConverter.convertToDto(e)).toList())
                .build();
    }
}
