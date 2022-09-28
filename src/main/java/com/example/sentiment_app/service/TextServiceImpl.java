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
import com.example.sentiment_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class TextServiceImpl implements TextService {

    private TextRepository textRepository;

    private UserRepository userRepository;

    private ExternalAPI externalApi;
    @Autowired
    private APIHandler apiHandler;
    private Text text;

    public TextServiceImpl(TextRepository textRepository, ExternalAPI externalApi) {
        this.textRepository = textRepository;
        this.externalApi = externalApi;
       // this.apiHandler = apiHandler;

    }


    /*public TextDto createText(CreateTextDto textDto){
        Text text = TextConverter.convertCreateTextDtoToEntity(textDto);
        text = textRepository.save(text);
        HttpResponse<String> response = HttpClient.newHttpClient().send(text.getMessage());
        return TextConverter.convertToDto(text);
    }*/





    @Override
    public Text getTextById(Integer id) {
                return textRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("It doesn't exist any text with the following ID: " + id));

    }

    @Override
    public TextDto createText(CreateTextDto textDto ) {
        text = TextConverter.convertCreateTextDtoToEntity(textDto);
        try {
            text = apiHandler.APIHandler(textDto.toString());
            //externalApi.postRequest(textDto.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //text = textRepository.save(text);
        return TextConverter.convertToDto(textRepository.save(text));
    }


    public List<TextDto> findAllTexts(User user) {
        List<TextDto> text = textRepository.findAll().stream().map(e->TextConverter.convertToDto(e)).toList();
        return text;
    }
    public List<Text> findAllText(User user) {
        return textRepository.findAll();
    }

}

