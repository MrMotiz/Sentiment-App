package com.example.sentiment_app.repository;

import com.example.sentiment_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJPA extends JpaRepository<User,Integer> {
}
