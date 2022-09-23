package com.example.sentiment_app.command;

import com.example.sentiment_app.model.Text;

public class TextConverter {

    public static CreateTextDto textDto (Text text) {
        return CreateTextDto.builder()
                .negativeSentimentPercentage(text.getNegativeSentimentPercentage())
                .positiveSentimentPercentage(text.getPositiveSentimentPercentage())
                .neutralSentimentPercentage(text.getNeutralSentimentPercentage())
                .message(text.getMessage())
                .created(text.getCreated())
                .build();

    }
    public static Text toEntity (CreateTextDto createTextDto) {
        return Text.builder()
                .negativeSentimentPercentage(createTextDto.getNegativeSentimentPercentage())
                .positiveSentimentPercentage(createTextDto.getPositiveSentimentPercentage())
                .neutralSentimentPercentage(createTextDto.getNegativeSentimentPercentage())
                .message(createTextDto.getMessage())
                .created(createTextDto.getCreated())
                .build();
    }
}
