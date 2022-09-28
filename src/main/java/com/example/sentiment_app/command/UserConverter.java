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
                .build();
    }

    public static User convertCreateUserDtoToEntity(CreateUserDto createUserDto) {
        return User.builder()
                .firstName(createUserDto.getFirstName())
                .lastName(createUserDto.getLastName())
                .age(createUserDto.getAge())
                .city(createUserDto.getCity())
                .gender(createUserDto.getGender())
                .build();

    }
}
