package com.example.springjpaexercise.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "author")
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    private Long id;
    private String name;
}