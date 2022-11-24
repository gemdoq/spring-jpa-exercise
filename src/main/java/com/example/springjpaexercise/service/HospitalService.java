package com.example.springjpaexercise.service;

import com.example.springjpaexercise.repository.HospitalRepository;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }
}