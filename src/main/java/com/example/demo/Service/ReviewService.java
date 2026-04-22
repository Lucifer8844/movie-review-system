package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Respository.ReviewRepository;
import com.example.demo.model.Review;

@Service
public class ReviewService {
	@Autowired
	ReviewRepository RevRepo;//creating reference variable for Repository class

	public Review insert(Review r) {
		return RevRepo.save(r);
	}
	
	
	
	
	

}
