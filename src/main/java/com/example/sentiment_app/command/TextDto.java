package com.example.sentiment_app.command;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Data
@Builder
public class TextDto {

    @NotNull
    private Integer id;
    @NotNull
    private double positiveSentimentPercentage;
    @NotNull
    private double negativeSentimentPercentage;
    @NotNull
    private double neutralSentimentPercentage;
    @NotBlank
    private String message;
    @NotNull
    private LocalDateTime created;
}
