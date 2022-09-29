package com.example.sentiment_app.command;

import com.example.sentiment_app.model.Text;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Data
public class CreateUserDto {
    @NotBlank(message = "First name required")
    private String firstName;
    @NotBlank (message = "Last name required")
    private String lastName;
    @Min(value = 0, message = "Age must be greater than 0")
    private Integer age;
    @NotBlank(message = "City required")
    private String city;
    @NotBlank (message = "Please select gender")
    private String gender;
    @NotNull
    private List<Text> sentence;

}
