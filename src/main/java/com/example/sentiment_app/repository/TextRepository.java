package com.example.sentiment_app.repository;

import com.example.sentiment_app.model.Text;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextRepository extends JpaRepository<Text,Integer> {
}
