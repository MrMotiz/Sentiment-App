package com.example.sentiment_app.command;

import com.example.sentiment_app.model.Text;

public class TextConverter {

    public static TextDto convertToDto (Text text) {
        return TextDto.builder()
                .neg(text.getNeg())
                .pos(text.getPos())
                .neu(text.getNeu())
                .sentence(text.getSentence())
                .sentiment(text.getSentiment())
                //.created(text.getCreated())
                .build();


    }
    public static Text convertCreateTextDtoToEntity (CreateTextDto createTextDto) {
        return Text.builder()
                .neg(createTextDto.getNeg())
                .pos(createTextDto.getPos())
                .neu(createTextDto.getNeg())
                .sentence(createTextDto.getSentence())
                .sentiment(createTextDto.getSentiment())
                //.created(createTextDto.getCreated())
                .build();
    }
}
