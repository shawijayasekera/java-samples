package com.java.samples.springboot.security.springbootsecurityjwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTUtil {

	private String SECRET_KEY = "secret";

	public String extractUsername(String token) { // extract the username from jwt token
		
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) { // extract the expiration date from jwt token
		
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) { // extract the claims from jwt token
		
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		
		return extractExpiration(token).before(new Date()); // compare the expiration date with current date and returns that token expire or not
	}

	public String generateToken(UserDetails userDetails) {
		
		Map<String, Object> claims = new HashMap<>(); // can set any specific information as claims. currently an empty map
		return createToken(claims, userDetails.getUsername());
	}

	private String createToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())) // subject is the person who has been authenticated. need to add token issue dated
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // sets token expiration date
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact(); // sign the token with algorithm and secret key
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		
		final String username = extractUsername(token); // extract the username 
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token)); // checks that extracted username is same as the username in UserDetails object. also check the token expire or not
	}
}
