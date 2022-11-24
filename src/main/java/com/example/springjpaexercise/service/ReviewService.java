package com.example.springjpaexercise.service;

import com.example.springjpaexercise.domain.dto.HospitalResponse;
import com.example.springjpaexercise.domain.dto.ReviewRequest;
import com.example.springjpaexercise.domain.dto.ReviewResponse;
import com.example.springjpaexercise.domain.entity.Hospital;
import com.example.springjpaexercise.domain.entity.Review;
import com.example.springjpaexercise.repository.HospitalRepository;
import com.example.springjpaexercise.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;

    public ReviewService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }

    public ReviewResponse create(Integer id, ReviewRequest reviewRequest) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);
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

    public ReviewResponse getOneReview(Integer id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        Review review = optionalReview.get();
        ReviewResponse reviewResponse = Review.of(review, id+"번 리뷰가 조회되었습니다.");
        return reviewResponse;
    }

    public List<ReviewResponse> getHospitalReviews(Integer id) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        Hospital hospital = optionalHospital.get();
        List<ReviewResponse> reviewResponses = hospital.getReviews().stream()
                .map(review -> ReviewResponse.of(review, id+"번 리뷰가 조회되었습니다.")).collect(Collectors.toList());
        return reviewResponses;
    }
}