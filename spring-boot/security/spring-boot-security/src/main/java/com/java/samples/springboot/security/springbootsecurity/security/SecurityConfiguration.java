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
			.password("{noop}user") // with {noop} passwords will store as clear text
			.roles("USER")
			.and() // and will return same object with same status. in here it is inMemoryAuthentication. so we can do the method chaining
			.withUser("admin")
			.password("{noop}admin")
			.roles("ADMIN"); // calling methods like this called as method chaining
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// Need to configure from most restricted to least restricted
		http.authorizeRequests()
			.antMatchers("/admin").hasRole("ADMIN") // only users with ADMIN role can access this page
			.antMatchers("/user").hasAnyRole("ADMIN", "USER") // only users with USER role can access this page
			.antMatchers("/").permitAll() // root URL - this means all can access the home page
			.and()
			.formLogin(); // this means form based login
	}
}
