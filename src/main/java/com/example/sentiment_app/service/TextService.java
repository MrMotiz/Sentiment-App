package com.example.sentiment_app.service;

import com.example.sentiment_app.model.Text;
import com.example.sentiment_app.model.User;

import java.util.List;

public interface TextService {

    Text getTextById(Integer id);

    Text addText(Text text);

    Text addTextToUser(Text text, User user);

}
