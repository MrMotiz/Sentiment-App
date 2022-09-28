package com.example.sentiment_app.command;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Data
@Builder
public class TextDto {



    private double pos;

    private double neg;

    private double neu;
    @NotBlank
    private String sentence;
    private String sentiment;
    //@NotNull
    //private LocalDateTime created;
}
