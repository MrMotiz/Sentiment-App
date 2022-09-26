package com.example.sentiment_app.api;

import com.example.sentiment_app.model.Text;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExternalAPI {


    private Text text;
    public ExternalAPI() throws IOException, InterruptedException {
    }
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://text-analysis12.p.rapidapi.com/article-extraction/api/v1.3"))
                .header("X-RapidAPI-Key", "95bd6ffc51mshd854e2b69156aaap139628jsn391b570980b5")
                .POST(HttpRequest.BodyPublishers.ofString(text.getMessage()))
                .build();

        HttpClient httpClient = new HttpClient();

        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());

    HttpRequest getRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://text-analysis12.p.rapidapi.com/article-extraction/api/v1.3/"+ text.getId()))
            .header("X-RapidAPI-Key", "95bd6ffc51mshd854e2b69156aaap139628jsn391b570980b5")
            .build();

    HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());


}
