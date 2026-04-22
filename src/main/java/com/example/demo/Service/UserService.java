package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Respository.UserRepo;
import com.example.demo.model.MessageResp;
import com.example.demo.model.UserInfo;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired UserRepo ur;

	public UserInfo validateByEmail(String email) {
		
		return ur.findByEmail(email);
	}
	
	public UserInfo validateByUsername(String username) {
		
		return ur.findByUsername(username);
	}

	public MessageResp saveUser(UserInfo u) {
		ur.save(u);
		return new MessageResp("Registration success");
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		
		UserInfo u=ur.findByUsername(username);
		
		UserDetails ud=User.withUsername(u.getUsername()).password(u.getPassword()).roles("user").build();
		
		return ud;
	}
	
	
	public UserInfo loadUser(String username) {
		
		
		
		UserInfo u=ur.findByUsername(username);
		
		
		
		return u;
	}

	
	public UserInfo getById(int id) {
		return ur.findById(id).get();
	}
	
	
}
