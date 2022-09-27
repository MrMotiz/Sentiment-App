package com.example.sentiment_app.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class CreateTextDto {

    @NotNull
    private double pos;
    @NotNull
    private double neg;
    @NotNull
    private double neu;
    @NotBlank(message = "Please write your thoughts")
    private String sentence;
    @NotNull
    private LocalDateTime created;


}
