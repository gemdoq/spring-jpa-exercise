package com.example.springjpaexercise.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class ReviewResponse {
    private Integer id;
    private String userName;
    private String title;
    private String content;
    private String message;
}