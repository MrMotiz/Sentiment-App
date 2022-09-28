package com.example.sentiment_app.command;

import com.example.sentiment_app.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class CreateTextDto {

    private double pos;
    private double neg;
    private double neu;
    @NotBlank(message = "Please write your thoughts")
    private String sentence;
    private LocalDate date;
    private String sentiment;
    private User user;

}
