package com.example.sentiment_app.api;


import com.example.sentiment_app.model.Text;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.awt.SystemColor.text;

@Component
public class ExternalAPI {

    private String finalMessage;

    public String postRequest(Text text) throws IOException, InterruptedException {

        finalMessage = text.getSentence();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://text-analysis12.p.rapidapi.com/sentiment-analysis/api/v1.1"))
                    .header("content-type", "application/json")
                    .header("X-RapidAPI-Key", "95bd6ffc51mshd854e2b69156aaap139628jsn391b570980b5")
                    .header("X-RapidAPI-Host", "text-analysis12.p.rapidapi.com")
                    .method("POST", HttpRequest.BodyPublishers.ofString("{\"language\":\"english\",\"text\":\"" + finalMessage + "\"}"))
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            return response.body();
    }
}
