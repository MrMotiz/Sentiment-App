package com.example.sentiment_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Text {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double pos;
    private double neg;
    private double neu;
    private String sentence;
    private String sentiment;
    private LocalDate date= java.time.LocalDate.now();

    @ManyToOne
    @JsonIgnore
    private User user;
}
