package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.MovieService;
import com.example.demo.model.Movies;

@RestController
@RequestMapping("/movies")
@CrossOrigin("http://localhost:4200")
public class MovieController {
	
	@Autowired MovieService ms;
	
	@GetMapping("/list")
	@CrossOrigin("http://localhost:4200")
	public List<Movies> getAll(){
		return ms.getMovies();
	}

}
