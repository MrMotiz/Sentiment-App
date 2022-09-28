package com.example.sentiment_app.command;

import com.example.sentiment_app.model.Text;

public class TextConverter {

    public static TextDto convertToDto (Text text) {
        return TextDto.builder()
                .id(text.getId())
                .neg(text.getNeg())
                .pos(text.getPos())
                .neu(text.getNeu())
                .sentence(text.getSentence())
                .sentiment(text.getSentiment())
                .date(text.getDate())
                .build();


    }

    public static Text convertTextToDtoToEntity (TextDto textDto){
        return Text.builder()
                .id(textDto.getId())
                .neg(textDto.getNeg())
                .pos(textDto.getPos())
                .neu(textDto.getNeu())
                .date(textDto.getDate())
                .sentence(textDto.getSentence())
                .sentiment(textDto.getSentiment())
                .build();
    }

    public static Text convertCreateTextDtoToEntity (CreateTextDto createTextDto) {
        return Text.builder()
                .neg(createTextDto.getNeg())
                .pos(createTextDto.getPos())
                .neu(createTextDto.getNeg())
                .sentence(createTextDto.getSentence())
                .sentiment(createTextDto.getSentiment())
                .date(createTextDto.getDate())
                .user(createTextDto.getUser())
                .build();
    }
}
