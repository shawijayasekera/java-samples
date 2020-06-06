package com.java.samples.springboot.security.springbootsecurityldap.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity // tells spring security to this is a configuration class
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
   
		// Set your configuration on the auth object
		auth.ldapAuthentication()
			.userDnPatterns("uid={0},ou=people") // the way of user information saved in ldif file. incoming username will set to the {0} for compare the information
			.groupSearchBase("ou=groups")
			.contextSource()
			.url("ldap://localhost:8389/dc=springframework,dc=org") // where is the ldap server hosted
			.and()
			.passwordCompare()
			.passwordEncoder(new BCryptPasswordEncoder()) // password encorder name
			.passwordAttribute("userPassword"); // password attribute name in the ldif file.
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// need to configure from most restricted to least restricted
		http.authorizeRequests()
			.anyRequest().fullyAuthenticated()
			.and()
			.formLogin(); // this means form based login
	}
}
