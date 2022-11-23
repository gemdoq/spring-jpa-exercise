package com.example.springjpaexercise.repository;

import com.example.springjpaexercise.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
