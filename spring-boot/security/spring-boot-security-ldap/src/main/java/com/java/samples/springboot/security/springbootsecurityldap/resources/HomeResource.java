package com.java.samples.springboot.security.springbootsecurityldap.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

	@GetMapping("/")
	public String index() {

		return "Home page";
	}
}
