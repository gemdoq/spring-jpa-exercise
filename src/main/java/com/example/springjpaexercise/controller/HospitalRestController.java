package com.example.springjpaexercise.controller;

import com.example.springjpaexercise.domain.dto.HospitalResponse;
import com.example.springjpaexercise.domain.dto.ReviewRequest;
import com.example.springjpaexercise.domain.dto.ReviewResponse;
import com.example.springjpaexercise.service.HospitalService;
import com.example.springjpaexercise.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {

    private final HospitalService hospitalService;
    private final ReviewService reviewService;

    public HospitalRestController(HospitalService hospitalService, ReviewService reviewService) {
        this.hospitalService = hospitalService;
        this.reviewService = reviewService;
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewResponse> createReview(@PathVariable Integer id, @RequestBody ReviewRequest reviewRequest) {
        return ResponseEntity.ok().body(reviewService.create(id, reviewRequest));
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<ReviewResponse>> getHospitalReviews(@PathVariable Integer id) {
        return ResponseEntity.ok().body(reviewService.getHospitalReviews(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> getHospital(@PathVariable Integer id) {
        return ResponseEntity.ok().body(hospitalService.getHospital(id));
    }
}