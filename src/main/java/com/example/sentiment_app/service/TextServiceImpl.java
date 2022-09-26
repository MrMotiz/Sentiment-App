package com.example.sentiment_app.service;

import com.example.sentiment_app.command.CreateTextDto;
import com.example.sentiment_app.command.TextConverter;
import com.example.sentiment_app.command.TextDto;
import com.example.sentiment_app.exceptions.ResourceNotFoundException;
import com.example.sentiment_app.model.Text;
import com.example.sentiment_app.model.User;
import com.example.sentiment_app.repository.TextRepository;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;

@Service
public class TextServiceImpl implements TextService {

    private TextRepository textRepository;

    public TextServiceImpl(TextRepository textRepository) {
        this.textRepository = textRepository;
    }


    public TextDto createText(CreateTextDto textDto){
        Text text = TextConverter.convertCreateTextDtoToEntity(textDto);
        text = textRepository.save(text);
        HttpResponse<String> response = HttpClient.newHttpClient().send(textRepository.getMessage, HttpResponse.BodyHandlers.ofString());
        return TextConverter.convertToDto(text);
    }

    @Override
    public Text getTextById(Integer id) {
                return textRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("It doesn't exist any text with the following ID: " + id));

    }

    @Override
    public Text addText(Text text) {
        return textRepository.save(text);
    }

    @Override
    public Text addTextToUser(Text text, User user) {
        text.setUser(user);
        return textRepository.save(text);
    }
    }
}
