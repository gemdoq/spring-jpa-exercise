package com.example.springjpaexercise.repository;

import com.example.springjpaexercise.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}