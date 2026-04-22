package com.example.demo.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Table(name="ReviewId")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reviewId")
	Integer ReviewId;
	
	@Column(name="horrorScore")
	Integer HorrorScore;
	@Column(name="dramaScore")
	Integer DramaScore;
	@Column(name="cinematographyScore")
	Integer CinematographyScore;
	@Column(name="characterDevelopmentScore")
	Integer CharacterDevelopmentScore;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private UserInfo userinfo;
	@OneToOne
	private Movies movie;
}	

