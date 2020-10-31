package com.test.springboot.springbootkafka.springbootkafkaconsumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.test.springboot.springbootkafka.springbootkafkaconsumer.dto.User;

@Service
public class KafkaConsumer {

	@KafkaListener(topics = "test_springboot_kafka_producer_user_topic", groupId = "group_json", containerFactory = "userKafkaListenerContainerFactory")
	public void consumeJson(User user) {

		System.out.println("Consumed user: " + user);
	}

	@KafkaListener(topics = "test_springboot_kafka_producer_string_topic", groupId = "group_id")
	public void consume(String message) {
		
		System.out.println("Consumed string: " + message);
	}
}
