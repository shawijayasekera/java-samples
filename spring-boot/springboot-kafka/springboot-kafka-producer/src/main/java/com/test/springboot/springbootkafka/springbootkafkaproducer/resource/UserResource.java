package com.test.springboot.springbootkafka.springbootkafkaproducer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.springboot.springbootkafka.springbootkafkaproducer.dto.User;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;
	
	private static final String TOPIC = "test_springboot_kafka_producer_topic";
	
	@PostMapping
	public String publishMessage(@RequestBody User user) {
		
		kafkaTemplate.send(TOPIC, user);
		return "Published successfully";
	}
}
