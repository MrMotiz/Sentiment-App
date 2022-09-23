package com.example.sentiment_app.service;

import com.example.sentiment_app.command.CreateTextDto;
import com.example.sentiment_app.command.TextConverter;
import com.example.sentiment_app.model.Text;
import com.example.sentiment_app.repository.TextRepository;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class TextService {


    private TextRepository textRepository;

    public TextService(TextRepository textRepository) {
        this.textRepository = textRepository;
    }


    public TextDto createText(CreateTextDto textDto){
        Text text = TextConverter.convertCreateTExtDtoToEntity(textDto);
        text = textRepository.save(text);
        HttpResponse<String> response = HttpClient.newHttpClient().send(textRepository.getMessage, HttpResponse.BodyHandlers.ofString());
        return TextConverter.convertTextDto(text, response);

    }

}
