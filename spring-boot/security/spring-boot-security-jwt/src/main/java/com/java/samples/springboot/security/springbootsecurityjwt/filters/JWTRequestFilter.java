package com.java.samples.springboot.security.springbootsecurityjwt.filters;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.java.samples.springboot.security.springbootsecurityjwt.services.MyUserDetailsService;
import com.java.samples.springboot.security.springbootsecurityjwt.util.JWTUtil;

@Component // this is use because we need to load this filter on spring container
public class JWTRequestFilter extends OncePerRequestFilter {

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Autowired
	private JWTUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String authorizationHeader = request.getHeader("Authorization"); // extract the Authorization header from the headers
		
		String userName = null;
		String jwt = null;
		
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
		
			jwt = authorizationHeader.substring(7); // extract the token using substring. 7 is used because Bearer has 7 with the space
			userName = jwtUtil.extractUsername(jwt);			
		}
		
		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) { // userName should not be empty and verifying that something is not already gone to the security context

			UserDetails userDetails = this.myUserDetailsService.loadUserByUsername(userName);

			if (jwtUtil.validateToken(jwt, userDetails)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities()); // do the authentication using UsernamePasswordAuthenticationToken
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); // sets what are the details in the request
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken); // sets details to the security context
			}
		}
		
		filterChain.doFilter(request, response); // passing request to the other filters
	}
}
