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


    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Min(0)
    private Integer age;
    @NotBlank
    private String city;
    @NotBlank
    private String gender;

}
