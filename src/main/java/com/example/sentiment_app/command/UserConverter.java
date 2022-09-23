package com.example.sentiment_app.command;

import com.example.sentiment_app.model.User;

public class UserConverter {

    public static UserDto convertToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .age(user.getAge())
                .city(user.getCity())
                .gender(user.getGender())
                .build();
    }

    public static User convertCreateUserDtoToEntity(CreateUserDto createUserDto) {
        return User.builder()
                .name(createUserDto.getName())
                .username(createUserDto.getUsername())
                .age(createUserDto.getAge())
                .city(createUserDto.getCity())
                .gender(createUserDto.getGender())
                .build();

    }
}
