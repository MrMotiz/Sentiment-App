package com.example.sentiment_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "user")

public class Text {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

    private double positiveSentimentPercentage;
    private double negativeSentimentPercentage;
    private double neutralSentimentPercentage;

    private LocalDateTime created;

    @ManyToOne
    @JsonIgnore
    private User user;
}