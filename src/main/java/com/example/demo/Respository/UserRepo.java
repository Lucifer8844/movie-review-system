package com.example.demo.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserInfo;

public interface UserRepo extends JpaRepository<UserInfo, Integer> {

	public UserInfo findByEmail(String email);
	public UserInfo findByUsername(String username);
}
