package com.java.samples.springboot.faulttolerance.resilience.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.java.samples.springboot.faulttolerance.resilience.moviecatalogservice.models.CatalogItem;
import com.java.samples.springboot.faulttolerance.resilience.moviecatalogservice.models.UserRating;
import com.java.samples.springboot.faulttolerance.resilience.moviecatalogservice.services.MovieInfo;
import com.java.samples.springboot.faulttolerance.resilience.moviecatalogservice.services.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	MovieInfo movieInfo;
	
	@Autowired
	UserRatingInfo userRatingInfo;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		// get all rated movie IDs
		UserRating ratings = userRatingInfo.getUserRating(userId);

		return ratings.getRatings().stream().map(rating -> {
			return movieInfo.getCatalogItem(rating);
		}).collect(Collectors.toList());
	}
}
