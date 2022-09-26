package com.example.sentiment_app.controller;

import com.example.sentiment_app.command.CreateTextDto;
import com.example.sentiment_app.command.CreateUserDto;
import com.example.sentiment_app.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {

    private UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }
/*
    @PostMapping ("/createUser")
    public ResponseEntity<?> createUser(@RequestBody CreateUserDto userDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream().map(e->e.getDefaultMessage()).toList();
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userServiceImpl.createText(userDto), HttpStatus.CREATED);
    }

    @PostMapping ("/{id}/text")
    public ResponseEntity<?> createText(@PathVariable Integer id, @RequestBody CreateTextDto textDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream().map(e->e.getDefaultMessage()).toList();
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userServiceImpl.createText(id, textDto), HttpStatus.OK);

    }


*/

}
