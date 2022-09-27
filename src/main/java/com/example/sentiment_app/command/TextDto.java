package com.example.sentiment_app.command;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Data
@Builder
public class TextDto {

    @NotNull
    private Integer id;
    @NotNull
    private double pos;
    @NotNull
    private double neg;
    @NotNull
    private double neu;
    @NotBlank
    private String sentence;
    @NotNull
    private LocalDateTime created;
}
