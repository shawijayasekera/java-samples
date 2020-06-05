package com.java.samples.springboot.security.springbootsecurityjdbc.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Set your configuration on the auth object
		auth.jdbcAuthentication()
			.dataSource(dataSource); // for the embedded databases spring will automatically creates a datasource		
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
