package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter  //Setters and getter methods from lombok
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Movies")
public class Movies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="movieId")
	Integer MovieId;
	@Column(name="description")
	String Description;
	@Column(name="movieName")
	String Moviename;
	
	String imgurl;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private Review review;
	

	
	
	
	

}
