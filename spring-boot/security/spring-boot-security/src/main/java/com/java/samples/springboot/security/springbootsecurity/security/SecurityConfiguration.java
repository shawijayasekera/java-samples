package com.java.samples.springboot.security.springbootsecurity.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// Need to configure from most restricted to least restricted
		http.authorizeRequests()
			.antMatchers("/admin").hasRole("ADMIN") // Only users with ADMIN role can access this page
			.antMatchers("/user").hasAnyRole("ADMIN", "USER") // Only users with USER role can access this page
			.antMatchers("/").permitAll() // Root URL - this means all can access the home page
			.and()
			.formLogin();
	}
}
