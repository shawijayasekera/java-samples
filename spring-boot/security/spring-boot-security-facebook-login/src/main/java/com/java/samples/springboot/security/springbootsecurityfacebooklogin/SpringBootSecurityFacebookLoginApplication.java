package com.java.samples.springboot.security.springbootsecurityfacebooklogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
@EnableOAuth2Sso // instruct springboot to do the oauth based authentication 
public class SpringBootSecurityFacebookLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityFacebookLoginApplication.class, args);
	}

}
