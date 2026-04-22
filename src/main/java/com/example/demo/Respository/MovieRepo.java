package com.example.demo.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Movies;

public interface MovieRepo extends JpaRepository<Movies, Integer> {

}
