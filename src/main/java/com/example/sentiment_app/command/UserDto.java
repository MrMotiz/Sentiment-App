package com.example.sentiment_app.command;

import com.example.sentiment_app.model.Gender;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Builder
@Data
public class UserDto {

    @NotNull
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String username;
    @Min(0)
    private String age;
    @NotBlank
    private String city;
    @NotBlank
    Gender gender;

}
