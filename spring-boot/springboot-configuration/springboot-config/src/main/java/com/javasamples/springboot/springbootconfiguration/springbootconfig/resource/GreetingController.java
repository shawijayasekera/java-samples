package com.javasamples.springboot.springbootconfiguration.springbootconfig.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Value("${my.greeting}")
	private String greetingMessage;

	@Value("${app.description}")
	private String appGreeting;

	@GetMapping("/greeting")
	public String greeting() {

		return greetingMessage;
	}

	@GetMapping("/appgreeting")
	public String appGreeting() {

		return appGreeting;
	}
}
