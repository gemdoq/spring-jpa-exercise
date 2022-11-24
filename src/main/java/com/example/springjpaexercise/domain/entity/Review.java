package com.example.springjpaexercise.domain.entity;

import com.example.springjpaexercise.domain.dto.ReviewResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "review")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String userName;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    public static ReviewResponse of(Review review, String message) {
        return new ReviewResponse(
                review.getId(),
                review.getUserName(),
                review.getTitle(),
                review.getContent(),
                message
        );
    }
}
