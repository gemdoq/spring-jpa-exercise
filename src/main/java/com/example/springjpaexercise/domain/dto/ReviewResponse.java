package com.example.springjpaexercise.domain.dto;

import com.example.springjpaexercise.domain.entity.Review;
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

    public static ReviewResponse of(Review review, String message) {
        return ReviewResponse.builder()
                .id(review.getId())
                .userName(review.getUserName())
                .title(review.getTitle())
                .content(review.getContent())
                .message(message)
                .build();
    }
}