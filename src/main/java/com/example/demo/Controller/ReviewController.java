package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.MovieService;
import com.example.demo.Service.ReviewService;
import com.example.demo.Service.UserService;
import com.example.demo.dto.MovieDto;
import com.example.demo.model.MessageResp;
import com.example.demo.model.Movies;
import com.example.demo.model.Review;
import com.example.demo.model.UserInfo;

@RestController
@RequestMapping("/review")
@CrossOrigin("http://localhost:4200")
public class ReviewController {
	
	@Autowired ReviewService rs;
	@Autowired UserService us;
	@Autowired MovieService ms;
	
@PostMapping("/save")	
@CrossOrigin("http://localhost:4200")
	ResponseEntity<MessageResp> save(@RequestBody MovieDto m) {
	
	
	UserInfo activeUser=us.getById(m.getUserInfo());
	Movies activeMovie=ms.getById(m.getMovie());
	
		Review r=new Review();
		r.setCharacterDevelopmentScore(m.getCharacterDevelopmentScore());
		r.setCinematographyScore(m.getCinematographyScore());
		r.setDramaScore(m.getDramaScore());
		r.setHorrorScore(m.getHorrorScore());
		r.setMovie(activeMovie);
		r.setUserinfo(activeUser);
		rs.insert(r);
		return new ResponseEntity<MessageResp>(new MessageResp("Thank you for Rating us."),HttpStatus.OK);
	
	}


	
	
}
