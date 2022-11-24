package com.example.springjpaexercise.service;

import com.example.springjpaexercise.domain.dto.ReviewRequest;
import com.example.springjpaexercise.domain.dto.ReviewResponse;
import com.example.springjpaexercise.domain.entity.Hospital;
import com.example.springjpaexercise.domain.entity.Review;
import com.example.springjpaexercise.repository.HospitalRepository;
import com.example.springjpaexercise.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {
    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;

    public ReviewService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }

    public ReviewResponse create(ReviewRequest reviewRequest) {
        Optional<Hospital> hospital = hospitalRepository.findById(reviewRequest.getHospitalId());
        Review review = Review.builder()
                .userName(reviewRequest.getUserName())
                .title(reviewRequest.getTitle())
                .content(reviewRequest.getContent())
                .hospital(hospital.get())
                .build();
        Review savedReview = reviewRepository.save(review);
        return new ReviewResponse(
                savedReview.getId(),
                savedReview.getUserName(),
                savedReview.getTitle(),
                savedReview.getContent(),
                "리뷰 등록 성공했습니다."
        );
    }
}