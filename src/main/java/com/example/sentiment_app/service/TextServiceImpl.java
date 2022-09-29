package com.example.sentiment_app.service;

import com.example.sentiment_app.api.APIHandler;
import com.example.sentiment_app.api.ExternalAPI;
import com.example.sentiment_app.command.CreateTextDto;
import com.example.sentiment_app.command.TextConverter;
import com.example.sentiment_app.command.TextDto;
import com.example.sentiment_app.exceptions.ResourceNotFoundException;
import com.example.sentiment_app.model.Text;
import com.example.sentiment_app.model.User;
import com.example.sentiment_app.repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TextServiceImpl implements TextService {

    private TextRepository textRepository;

    private ExternalAPI externalApi;
    @Autowired
    private APIHandler apiHandler;
    private Text text;

    public TextServiceImpl(TextRepository textRepository, ExternalAPI externalApi) {
        this.textRepository = textRepository;
        this.externalApi = externalApi;

    }

    @Override
    public Text getTextById(Integer id) {
                return textRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("It doesn't exist any text with the following ID: " + id));

    }

    @Override
    public TextDto createText(CreateTextDto textDto) {
        text = TextConverter.convertCreateTextDtoToEntity(textDto);
        try {
            text = apiHandler.APIHandler(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TextConverter.convertToDto(textRepository.save(text));
    }

    @Override
    public List<TextDto> findAllTexts(User user) {
        List<TextDto> text = textRepository.findAll().stream().map(e->TextConverter.convertToDto(e)).toList();
        return text;
    }

}

