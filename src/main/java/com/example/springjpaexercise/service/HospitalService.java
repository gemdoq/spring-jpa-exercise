package com.example.springjpaexercise.service;

import com.example.springjpaexercise.domain.dto.HospitalResponse;
import com.example.springjpaexercise.domain.dto.ReviewResponse;
import com.example.springjpaexercise.domain.entity.Hospital;
import com.example.springjpaexercise.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalResponse getHospital(Integer id) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        Hospital hospital = optionalHospital.get();
        List<ReviewResponse> reviewResponses = hospital.getReviews().stream()
                .map(review -> ReviewResponse.of(review, "리뷰가 조회되었습니다.")).collect(Collectors.toList());
        return HospitalResponse.builder()
                .id(hospital.getId())
                .hospitalName(hospital.getHospitalName())
                .roadNameAddress(hospital.getRoadNameAddress())
                .reviewResponses(reviewResponses)
                .build();
    }
}