package com.example.sentiment_app.controller;

import com.example.sentiment_app.command.CreateTextDto;
import com.example.sentiment_app.command.CreateUserDto;
import com.example.sentiment_app.command.TextDto;
import com.example.sentiment_app.command.UserDto;
import com.example.sentiment_app.model.Text;
import com.example.sentiment_app.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SentimentApp")
public class UserController {

    private UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserDto userDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream().map(e->e.getDefaultMessage()).toList();
            return new ResponseEntity<>(errors, HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(userServiceImpl.createUser(userDto), HttpStatus.CREATED);
    }

    @PostMapping ("/{id}/text")
    public ResponseEntity<?> createSentence(@PathVariable Integer id, @RequestBody CreateTextDto textDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream().map(e->e.getDefaultMessage()).toList();
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userServiceImpl.createSentence(id, textDto), HttpStatus.OK);

    }

    @GetMapping ("/{id}/text")
    public ResponseEntity<List<TextDto>> findAllTextsFromUser(@PathVariable Integer id){
        if(id==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userServiceImpl.findAllTexts(id), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<UserDto> findSpecificUser(@PathVariable Integer id){
        if(id==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userServiceImpl.findSpecificUser(id), HttpStatus.FOUND);
    }



}
