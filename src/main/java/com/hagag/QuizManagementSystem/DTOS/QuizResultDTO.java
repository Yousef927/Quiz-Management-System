package com.hagag.QuizManagementSystem.DTOS;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizResultDTO {
    private Integer studentScore;
    private Integer QuizTotalScore;
}
