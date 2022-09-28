package com.example.sentiment_app.service;

import com.example.sentiment_app.command.CreateTextDto;
import com.example.sentiment_app.command.TextDto;
import com.example.sentiment_app.model.Text;
import com.example.sentiment_app.model.User;


public interface TextService {

    Text getTextById(Integer id);

    TextDto createText(CreateTextDto textDto);

}
