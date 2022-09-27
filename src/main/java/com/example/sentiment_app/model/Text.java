package com.example.sentiment_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;

    private double pos;
    private double neg;
    private double neu;
    private String sentence;
    private String sentiment;
    private LocalDateTime created;

    @ManyToOne
    @JsonIgnore
    private User user;
}
