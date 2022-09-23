package com.example.sentiment_app.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class CreateTextDto {

    private double positiveSentimentPercentage;
    private double negativeSentimentPercentage;
    private double neutralSentimentPercentage;
    private String messages;
    private LocalDateTime created;
}
