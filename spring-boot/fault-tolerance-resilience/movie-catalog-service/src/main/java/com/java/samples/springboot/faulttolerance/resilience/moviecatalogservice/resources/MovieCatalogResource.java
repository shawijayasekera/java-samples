package com.java.samples.springboot.faulttolerance.resilience.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.java.samples.springboot.faulttolerance.resilience.moviecatalogservice.models.CatalogItem;
import com.java.samples.springboot.faulttolerance.resilience.moviecatalogservice.models.Movie;
import com.java.samples.springboot.faulttolerance.resilience.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired  
	private RestTemplate restTemplate;
	
	//@Autowired
	//private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		// get all rated movie IDs
		UserRating ratings = restTemplate.getForObject("http://RATINGS-DATA-SERVICE/ratingsdata/users/" + userId, UserRating.class);

		return ratings.getRatings().stream().map(rating -> {
			
			// for each movie ID, call movie info service and get details
			Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" + rating.getMovieId(), Movie.class);
			
			/*
			 * Movie movie = webClientBuilder.build() .get()
			 * .uri("http://localhost:8082/movies/" + rating.getMovieId()) .retrieve()
			 * .bodyToMono(Movie.class) // this means (bodyToMono) you are getting
			 * asynchronous Movie type object or in other words you are getting that in
			 * feture .block();
			 */ // you are blocking execution till you get the Movie object
				// this is like you are using asynchronous programming as synchronous way
			
			// put them all together
			return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
		}).collect(Collectors.toList());
	}
}
