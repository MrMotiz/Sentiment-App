package com.example.sentiment_app.command;

import com.example.sentiment_app.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.logging.log4j.message.Message;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class CreateTextDto {

    @NotNull
    private double positiveSentimentPercentage;
    @NotNull
    private double negativeSentimentPercentage;
    @NotNull
    private double neutralSentimentPercentage;
    @NotBlank(message = "Please write your thoughts")
    private String message;
    @NotNull
    private LocalDateTime created;


    public void setUser(User orElseThrow) {
    }
}
