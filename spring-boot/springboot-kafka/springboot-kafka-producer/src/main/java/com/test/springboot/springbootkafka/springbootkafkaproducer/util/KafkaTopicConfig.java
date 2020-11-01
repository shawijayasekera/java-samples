package com.test.springboot.springbootkafka.springbootkafkaproducer.util;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	@Autowired
	KafkaConfigDataHolder kafkaConfigDataHolder;

	@Bean
	public NewTopic userTopic() {

		return TopicBuilder.name(kafkaConfigDataHolder.getUserTopic()).partitions(1).replicas(1).build();
	}
}
