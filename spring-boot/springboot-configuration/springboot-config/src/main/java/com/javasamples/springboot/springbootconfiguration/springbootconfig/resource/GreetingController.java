package com.javasamples.springboot.springbootconfiguration.springbootconfig.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Value("${my.greeting}")
	private String greetingMessage;

	@Value("${app.description}")
	private String appGreeting;

	/*
	 * When there are no any required property found it will set to the default
	 * value "HI".
	 */
	@Value("${app.default.description: Hi}")
	private String defaultAppGreeting;

	/*
	 * When we want to get list of values, we can set it to the List. Values should
	 * be , separated.
	 */
	@Value("${app.list.values}")
	private List<String> appListValues;

	@GetMapping("/greeting")
	public String greeting() {

		return greetingMessage;
	}

	@GetMapping("/appgreeting")
	public String appGreeting() {

		return appGreeting;
	}

	@GetMapping("/defaultappgreeting")
	public String defaultAppGreeting() {

		return defaultAppGreeting;
	}
	
	@GetMapping("/valuelist")
	public String valueList() {

		return "" + appListValues;
	}
}
