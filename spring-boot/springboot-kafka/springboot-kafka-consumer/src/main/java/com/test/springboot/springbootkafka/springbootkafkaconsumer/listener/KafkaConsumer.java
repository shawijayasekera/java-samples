package com.test.springboot.springbootkafka.springbootkafkaconsumer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.test.springboot.springbootkafka.springbootkafkaconsumer.dto.User;
import com.test.springboot.springbootkafka.springbootkafkaconsumer.util.KafkaConfigDataHolder;

@Service
public class KafkaConsumer {

	@Autowired
	KafkaConfigDataHolder kafkaConfigDataHolder;
	
	@KafkaListener(topics = "#{kafkaConfigDataHolder.getUserTopic()}", groupId = "#{kafkaConfigDataHolder.getUserTopicGroupId()}", containerFactory = "userKafkaListenerContainerFactory")
	public void consumeJson(User user) {

		System.out.println("Consumed user: " + user);
	}

	@KafkaListener(topics = "#{kafkaConfigDataHolder.getStringTopic()}", groupId = "#{kafkaConfigDataHolder.getStringTopicGroupId()}")
	public void consume(String message) {
		
		System.out.println("Consumed string: " + message);
	}
}
