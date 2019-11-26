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

		System.out.println(headerDataHolder.getConsumerKey());
		System.out.println(headerDataHolder.getUserId());
		System.out.println(headerDataHolder.getContext());
		System.out.println(headerDataHolder.getApiVersion());
		System.out.println(headerDataHolder.getApiName());
		System.out.println(headerDataHolder.getVersion());
		System.out.println(headerDataHolder.getResource());
		System.out.println(headerDataHolder.getHttpMethod());
		System.out.println(headerDataHolder.getHostName());
		System.out.println(headerDataHolder.getApiPublisher());
		System.out.println(headerDataHolder.getApplicationName());
		System.out.println(headerDataHolder.getApplicationId());
		System.out.println(headerDataHolder.getOperator());
		System.out.println(headerDataHolder.getRequestId());
	}
}
