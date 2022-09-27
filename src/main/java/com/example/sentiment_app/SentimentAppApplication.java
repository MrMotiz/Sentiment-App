package com.example.sentiment_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class SentimentAppApplication {
	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(SentimentAppApplication.class,args);

		/*HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://text-analysis12.p.rapidapi.com/sentiment-analysis/api/v1.1"))
				.header("content-type", "application/json")
				.header("X-RapidAPI-Key", "95bd6ffc51mshd854e2b69156aaap139628jsn391b570980b5")
				.header("X-RapidAPI-Host", "text-analysis12.p.rapidapi.com")
				.method("POST", HttpRequest.BodyPublishers.ofString("{\"language\":\"english\",\"text\":\"this is a test\"}"))
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println(response.body());

		 */

	}

}
