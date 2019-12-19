package com.java.samples.springboot.faulttolerance.resilience.moviecatalogservice.services;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.java.samples.springboot.faulttolerance.resilience.moviecatalogservice.models.Rating;
import com.java.samples.springboot.faulttolerance.resilience.moviecatalogservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;;

@Service
public class UserRatingInfo {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackUserRating", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"), // timeout value in seconds
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"), // no of last requests
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"), // failure percentage of last no of requests
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000") // how many seconds to not send the request to endpoint
	})
	public UserRating getUserRating(String userId) {

		return restTemplate.getForObject("http://RATINGS-DATA-SERVICE/ratingsdata/users/" + userId, UserRating.class);
	}

	public UserRating getFallbackUserRating(String userId) {

		UserRating userRating = new UserRating();
		userRating.setUserId(userId);
		userRating.setRatings(Arrays.asList(new Rating("0", 0)));

		return userRating;
	}
}
