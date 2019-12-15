package com.java.samples.springboot.communication.discovery.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import com.java.samples.springboot.communication.discovery.moviecatalogservice.models.CatalogItem;
import com.java.samples.springboot.communication.discovery.moviecatalogservice.models.Movie;
import com.java.samples.springboot.communication.discovery.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	//@Autowired  
	//private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		//restTemplate = new RestTemplate();
		

		// get all rated movie IDs
		List<Rating> ratings = Arrays.asList(new Rating("1234", 4), new Rating("5678", 3));

		return ratings.stream().map(rating -> {
			
			//Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
			
			Movie movie = webClientBuilder.build()
				.get()
				.uri("http://localhost:8082/movies/" + rating.getMovieId())
				.retrieve()
				.bodyToMono(Movie.class) // this means (bodyToMono) you are getting asynchronous Movie type object or in other words you are getting that in feture
				.block(); // you are blocking execution till you get the Movie object
				// this is like you are using asynchronous programming as synchronous way
			
			return new CatalogItem(movie.getName(), "Test", rating.getRating());
		}).collect(Collectors.toList());

		// for each movie ID, call movie info service and get details

		// put them all together
	}
}
