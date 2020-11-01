package com.test.springboot.springbootkafka.springbootkafkaconsumer.util;

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

	@Value("${user.topic.group.id}")
	private String userTopicGroupId;

	@Value("${string.topic}")
	private String stringTopic;

	@Value("${string.topic.group.id}")
	private String stringTopicGroupId;

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

	public String getUserTopicGroupId() {
		return userTopicGroupId;
	}

	public void setUserTopicGroupId(String userTopicGroupId) {
		this.userTopicGroupId = userTopicGroupId;
	}

	public String getStringTopic() {
		return stringTopic;
	}

	public void setStringTopic(String stringTopic) {
		this.stringTopic = stringTopic;
	}

	public String getStringTopicGroupId() {
		return stringTopicGroupId;
	}

	public void setStringTopicGroupId(String stringTopicGroupId) {
		this.stringTopicGroupId = stringTopicGroupId;
	}
}
