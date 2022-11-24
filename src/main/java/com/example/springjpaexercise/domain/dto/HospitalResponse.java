package com.example.springjpaexercise.domain.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalResponse {
    private Integer id;
    private String hospitalName;
    private String roadNameAddress;
    private List<ReviewResponse> reviewResponses;
}