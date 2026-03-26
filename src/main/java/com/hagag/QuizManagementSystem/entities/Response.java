package com.hagag.QuizManagementSystem.entities;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Response {

    private String answer;
    private Integer questionId;


}
