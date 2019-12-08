package com.test.springboot.quickstart.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.springboot.quickstart.HeaderDataHolder;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private HeaderDataHolder headerDataHolder;

	public List<Topic> getAllTopics() {

		logAllRequestHeaders();
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);

		return topics;
	}

	public Optional<Topic> getTopic(String id) {

		logAllRequestHeaders();
		return topicRepository.findById(id);
	}

	public void addTopic(Topic topic) {

		logAllRequestHeaders();
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {

		logAllRequestHeaders();
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {

		logAllRequestHeaders();
		topicRepository.deleteById(id);
	}

	private void logAllRequestHeaders() {

		System.out.println("ConsumerKey : " + headerDataHolder.getConsumerKey());
		System.out.println("UserId : " + headerDataHolder.getUserId());
		System.out.println("Context : " + headerDataHolder.getContext());
		System.out.println("ApiVersion : " + headerDataHolder.getApiVersion());
		System.out.println("ApiName : " +headerDataHolder.getApiName());
		System.out.println("Version : " +headerDataHolder.getVersion());
		System.out.println("Resource : " +headerDataHolder.getResource());
		System.out.println("HttpMethod : " +headerDataHolder.getHttpMethod());
		System.out.println("HostName : " +headerDataHolder.getHostName());
		System.out.println("ApiPublisher : " +headerDataHolder.getApiPublisher());
		System.out.println("ApplicationName : " +headerDataHolder.getApplicationName());
		System.out.println("ApplicationId : " +headerDataHolder.getApplicationId());
		System.out.println("Operator : " +headerDataHolder.getOperator());
		System.out.println("RequestId : " +headerDataHolder.getRequestId());
	}
}
