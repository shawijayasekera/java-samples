package com.java.samples.springboot.security.springbootsecurityjwt.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.samples.springboot.security.springbootsecurityjwt.models.AuthenticationRequest;
import com.java.samples.springboot.security.springbootsecurityjwt.models.AuthenticationResponse;
import com.java.samples.springboot.security.springbootsecurityjwt.services.MyUserDetailsService;
import com.java.samples.springboot.security.springbootsecurityjwt.util.JWTUtil;

@RestController // The @Controller is a common annotation that is used to mark a class as Spring MVC Controller while @RestController is a special controller used in RESTFul web services and the equivalent of @Controller + @ResponseBody
public class HomeResource {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private JWTUtil jwtTokenUtil;

	@GetMapping("/hello")
	public String hello() {

		return "Hello World";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword())); // UsernamePasswordAuthenticationToken is the standard token that spring MVC uses for username and password. uses to do the authentication
		} catch (BadCredentialsException e) {

			throw new Exception("Incorrect username or password");
		}
		
		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());

		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
