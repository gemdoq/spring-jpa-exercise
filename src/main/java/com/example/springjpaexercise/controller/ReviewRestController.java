package com.example.springjpaexercise.controller;

import com.example.springjpaexercise.domain.dto.ReviewResponse;
import com.example.springjpaexercise.service.HospitalService;
import com.example.springjpaexercise.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewRestController {
    private final HospitalService hospitalService;
    private final ReviewService reviewService;

    public ReviewRestController(HospitalService hospitalService, ReviewService reviewService) {
        this.hospitalService = hospitalService;
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponse> getOneReview(@PathVariable Integer id) {
        return ResponseEntity.ok().body(reviewService.getOneReview(id));
    }
}