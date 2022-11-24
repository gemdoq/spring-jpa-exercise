package com.example.springjpaexercise.domain.dto;

import com.example.springjpaexercise.domain.entity.Hospital;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalResponse {
    private Integer id;
    private String hospitalName;
    private String roadNameAddress;

    public static HospitalResponse of(Hospital hospital) {
        return HospitalResponse.builder()
                .id(hospital.getId())
                .hospitalName(hospital.getHospitalName())
                .roadNameAddress(hospital.getRoadNameAddress())
                .build();
    }
}