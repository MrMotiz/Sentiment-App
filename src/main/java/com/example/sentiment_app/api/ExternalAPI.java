package com.example.sentiment_app.api;

import com.example.sentiment_app.command.TextDto;

import com.example.sentiment_app.model.Text;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ExternalAPI {


    private TextDto textDto;
    private Text text;



    public String postRequest(String message) throws IOException, InterruptedException, JSONException {

        //String message = text1.getSentence();

        //RestTemplate restTemplate = new RestTemplate
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://text-analysis12.p.rapidapi.com/sentiment-analysis/api/v1.1"))
                .header("content-type", "application/json")
                .header("X-RapidAPI-Key", "95bd6ffc51mshd854e2b69156aaap139628jsn391b570980b5")
                .header("X-RapidAPI-Host", "text-analysis12.p.rapidapi.com")
                .method("POST", HttpRequest.BodyPublishers.ofString("{\"language\":\"english\",\"text\":\"" + message + "\"}"))
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        return response.body();



/*
        JSONObject myJsonObj = new JSONObject(response.body());

        textDto.setSentiment(myJsonObj.getString("sentiment"));

        String sentimentList = myJsonObj.getString("aggregate_sentiment");


        JSONObject aggregate = new JSONObject(sentimentList);

        textDto.setNeg(Double.parseDouble(aggregate.getString("neg")));
        textDto.setNeu(Double.parseDouble(aggregate.getString("neu")));
        textDto.setPos(Double.parseDouble(aggregate.getString("pos")));
    }

    public String postRequest(String text) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://text-analysis12.p.rapidapi.com/sentiment-analysis/api/v1.1"))
                .header("content-type", "application/json")
                .header("X-RapidAPI-Key", "95bd6ffc51mshd854e2b69156aaap139628jsn391b570980b5")
                .header("X-RapidAPI-Host", "text-analysis12.p.rapidapi.com")
                .method("POST", HttpRequest.BodyPublishers.ofString("{\"language\":\"english\",\"text\":\"" + text + "\"}"))
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
*/
    }
}
