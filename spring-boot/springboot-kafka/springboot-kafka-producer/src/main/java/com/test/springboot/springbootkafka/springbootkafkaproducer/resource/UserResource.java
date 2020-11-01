package com.test.springboot.springbootkafka.springbootkafkaproducer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.springboot.springbootkafka.springbootkafkaproducer.dto.User;
import com.test.springboot.springbootkafka.springbootkafkaproducer.util.KafkaConfigDataHolder;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;
	
	@Autowired
	KafkaConfigDataHolder kafkaConfigDataHolder;
	
	@PostMapping
	public String publishMessage(@RequestBody User user) {
		
		kafkaTemplate.send(kafkaConfigDataHolder.getUserTopic(), user);
		return "Published successfully";
	}
}
