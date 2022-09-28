package com.example.sentiment_app.command;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
