package com.java.samples.springboot.security.springbootsecuritycustomlogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //The @Controller is a common annotation that is used to mark a class as Spring MVC Controller while @RestController is a special controller used in RESTFul web services and the equivalent of @Controller + @ResponseBody
public class LoginController {

	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
}
