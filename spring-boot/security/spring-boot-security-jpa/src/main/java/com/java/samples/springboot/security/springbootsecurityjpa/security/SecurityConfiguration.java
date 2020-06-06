package com.java.samples.springboot.security.springbootsecurityjpa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity // tells spring security to this is a configuration class
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
   
		// Set your configuration on the auth object
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// need to configure from most restricted to least restricted
		http.authorizeRequests()
			.antMatchers("/admin").hasRole("ADMIN") // only users with ADMIN role can access this page
			.antMatchers("/user").hasAnyRole("ADMIN", "USER") // only users with USER role can access this page
			.antMatchers("/").permitAll() // root URL - this means all can access the home page
			.and()
			.formLogin(); // this means form based login
	}
}
