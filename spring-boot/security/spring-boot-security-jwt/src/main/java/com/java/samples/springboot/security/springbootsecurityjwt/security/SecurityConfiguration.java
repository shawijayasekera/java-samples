package com.java.samples.springboot.security.springbootsecurityjwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.java.samples.springboot.security.springbootsecurityjwt.services.MyUserDetailsService;

@EnableWebSecurity // tells spring security to this is a configuration class
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
   
		// Set your configuration on the auth object
		auth.userDetailsService(myUserDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable() // disable the cross-site request forgery. cross-site request forgery is an attack that forces an end user to execute unwanted actions on a web application in which they’re currently authenticated. CSRF attacks specifically target state-changing requests, not theft of data, since the attacker has no way to see the response to the forged request
			.authorizeRequests().antMatchers("/authenticate").permitAll() // allow all to access /authenticate endpoint
			.anyRequest().authenticated();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {

		return super.authenticationManagerBean();
	}
}
