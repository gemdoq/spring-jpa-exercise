package com.example.springjpaexercise.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewRequest {
    private Integer hospitalId;
    private String userName;
    private String title;
    private String content;
}