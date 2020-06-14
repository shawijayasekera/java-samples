package com.java.samples.springboot.security.springbootsecuritycustomlogin.security;

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
			.anyRequest().authenticated()
			.and()
			.formLogin() // this means form based login
			.loginPage("/login") // load the customized login page instead of default login page
			.permitAll(); // everyone have access to the login page
	}
}
