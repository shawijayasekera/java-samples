package com.javasamples.springboot.springbootconfiguration.springbootconfig.resource;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javasamples.springboot.springbootconfiguration.springbootconfig.util.DBSettings;

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

	/*
	 * When we want to get key-value pairs, we can set it to the Map. We need to use
	 * # sign to get values as key-value pair. Using # is called as SPEL.
	 */
	@Value("#{${app.db.values}}")
	private Map<String, String> appDBMapValues;

	@Value("Constant greeting")
	private String constantGreeting;

	@Autowired
	private DBSettings dbSettings;
	
	@Autowired
	private Environment environment;

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

	@GetMapping("/valuemap")
	public String valueMap() {

		return "" + appDBMapValues;
	}

	@GetMapping("/constantgreeting")
	public String constantGreeting() {

		return constantGreeting;
	}

	@GetMapping("/dbconfigurations")
	public String dbConfigurations() {

		return " " + dbSettings.getConnection() + " " + dbSettings.getHost() + " " + dbSettings.getPort();
	}
	
	@GetMapping("/envdetails")
	public String envDetails() {

		return environment.toString(); 
	}
}
