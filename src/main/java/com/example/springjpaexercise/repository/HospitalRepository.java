package com.example.springjpaexercise.repository;

import com.example.springjpaexercise.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}