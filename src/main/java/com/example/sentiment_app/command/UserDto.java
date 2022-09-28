package com.example.sentiment_app.command;

import com.example.sentiment_app.model.Gender;
import com.example.sentiment_app.model.Text;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


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

    private List<TextDto> sentence;

}
