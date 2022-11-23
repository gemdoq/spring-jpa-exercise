package com.example.springjpaexercise.repository;

import com.example.springjpaexercise.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
