package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

@Table(name="UserInfo")
public class UserInfo {
	//table name/pojo class this directly goes to the UserController.java there in the getmapping part for getting the details
		//contains the entity of table or the columns of the tables
		
		@Id //specifies that it is a primary key
		@GeneratedValue(strategy = GenerationType.IDENTITY)//This specifies that the UserId will be generated automatically

		Integer userid;
		String username;
		String password;
		String email;
		
		@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
		private List<Review> review = new ArrayList<>();



}
