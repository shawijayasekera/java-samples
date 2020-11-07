package com.test.lambdas.lambdabasic.java8lambdastarter.stream;

import java.util.Arrays;
import java.util.List;

public class StreamExample1 {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60), 
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), 
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));
		
		/*
		 * stream method will convert the people collection to stream and do the
		 * filtration and the print. filter method expects the lambda expression of
		 * Predicate type
		 */
		// Get the people who has last name starting from "C" and print their first name
		people.stream()
		.filter(p -> p.getLastName().startsWith("C"))
		.forEach(p -> System.out.println(p.getFirstName()));
	}
}
