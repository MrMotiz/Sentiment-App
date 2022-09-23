package com.example.sentiment_app.command;

import com.example.sentiment_app.model.Gender;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Data
public class CreateUserDto {

    @NotBlank(message = "Name required")
    private String name;
    @NotBlank (message = "Username required")
    private String username;
    @Min(value = 0, message = "Age must be greater than 0")
    private String age;
    @NotBlank(message = "City required")
    private String city;
    @NotBlank (message = "Please select gender")
    Gender gender;
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String confirmPassword;

}
