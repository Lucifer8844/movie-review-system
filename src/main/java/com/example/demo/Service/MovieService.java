package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Respository.MovieRepo;
import com.example.demo.model.Movies;

@Service
public class MovieService {
	@Autowired MovieRepo mr;

	public List<Movies> getMovies() {
		
		return mr.findAll();
	}
	
	public Movies getById(int id) {
		return mr.findById(id).get();
	}

}
