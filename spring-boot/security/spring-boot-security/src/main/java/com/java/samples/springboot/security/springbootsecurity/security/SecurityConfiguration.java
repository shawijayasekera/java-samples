package com.java.samples.springboot.security.springbootsecurity.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Set your configuration on the auth object
		auth.inMemoryAuthentication()
			.withUser("user")
			.password("{noop}user")
			.roles("USER")
			.and()
			.withUser("admin")
			.password("{noop}admin")
			.roles("ADMIN");
	}
	
	public PasswordEncoder getPasswordEncoder() {
		
		return NoOpPasswordEncoder.getInstance(); // This is for using password as clear text otherwise you have to use hashing 
	}
}
