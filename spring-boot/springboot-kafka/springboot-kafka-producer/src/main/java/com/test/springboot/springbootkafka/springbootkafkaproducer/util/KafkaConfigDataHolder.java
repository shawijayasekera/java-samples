package com.test.springboot.springbootkafka.springbootkafkaproducer.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:kafka-config.properties")
public class KafkaConfigDataHolder {

	@Value("${kafka.server}")
	private String kafkaServer;
	
	@Value("${user.topic}")
	private String userTopic;

	public String getKafkaServer() {
		return kafkaServer;
	}

	public void setKafkaServer(String kafkaServer) {
		this.kafkaServer = kafkaServer;
	}

	public String getUserTopic() {
		return userTopic;
	}

	public void setUserTopic(String userTopic) {
		this.userTopic = userTopic;
	}
}
