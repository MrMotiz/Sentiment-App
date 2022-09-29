package com.example.sentiment_app.command;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Data
@Builder
public class TextDto {

    @JsonIgnore
    private Integer id;
    private double pos;

    private double neg;

    private double neu;
    @NotBlank
    private String sentence;
    private String sentiment;
    private LocalDate date;
}
