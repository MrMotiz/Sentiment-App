package com.example.sentiment_app.service;

import com.example.sentiment_app.model.Text;
import com.example.sentiment_app.repository.TextRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class TextService {


    Text text = new Text();
    private TextRepository textRepository;

    public TextService(TextRepository textRepository) throws IOException, InterruptedException {
        this.textRepository = textRepository;
    }


    public TextDto createText(CreateTextDto textDto){
        Text text = TextConverter.convertCreateTExtDtoToEntity(textDto);
        text = textRepository.save(text);
        HttpResponse<String> response = HttpClient.newHttpClient().send(text.getMessage, HttpResponse.BodyHandlers.ofString());
        return TextConverter.convertTextDto(text, response);

    }
    HttpRequest postRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://text-analysis12.p.rapidapi.com/article-extraction/api/v1.3"))
            .header("X-RapidAPI-Key", "95bd6ffc51mshd854e2b69156aaap139628jsn391b570980b5")
            .POST(HttpRequest.BodyPublishers.ofString(text.getMessage))
            .build();
    HttpClient httpsClient = HttpClient.newHttpClient();

    HttpResponse<String> postResponse = httpsClient.send(postRequest, HttpResponse.BodyHandlers.ofString());

}
