package com.example.demo.config;



import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter{

	
	@Bean
	protected PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Resource
	UserDetailsService userDetailsService;
	
	@Bean
	DaoAuthenticationProvider getDaoAuthenticationProvider() {

		
		DaoAuthenticationProvider d=new DaoAuthenticationProvider();
		d.setPasswordEncoder(passwordEncoder());
		d.setUserDetailsService(userDetailsService);
		
		return d;
		

	}
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		
		auth.authenticationProvider(getDaoAuthenticationProvider());
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/user/register","/user/login","/movies/list","/review/save").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().defaultSuccessUrl("http://localhost:4200/",true).loginPage("http://localhost:4200/login")
		.and().csrf().disable();
	}
	
	
	

}
