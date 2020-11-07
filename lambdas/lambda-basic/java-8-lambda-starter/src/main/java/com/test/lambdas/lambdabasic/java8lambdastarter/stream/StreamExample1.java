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
		 * Predicate type.
		 * 
		 * People collection is the source of stream in following example.
		 * filter is the operation
		 * forEach is the end/termination condition.
		 */
		// Get the people who has last name starting from "C" and print their first name
		System.out.println("First name of the people who has the last name starting from C");
		people.stream()
		.filter(p -> p.getLastName().startsWith("C"))
		.forEach(p -> System.out.println(p.getFirstName()));
		
		/*
		 * count the end/termination condition of the following stream. 
		 * Because it produce the end result.
		 */
		System.out.print("\n");
		System.out.println("Count of the people who has the last name starting from C");
		long count1 = people.stream()
						.filter(p -> p.getLastName().startsWith("C"))
						.count();
		System.out.println(count1);
		
		/* parallelStream do the iteration out of control from us. 
		 * If runtime decides, it need to the collection process parallel it will do it in multiple cores.
		 * Runtime can decide which part of the iteration do in which core.
		 */
		System.out.print("\n");
		long count2 = people.parallelStream()
						.filter(p -> p.getLastName().startsWith("C"))
						.count();
		System.out.println(count2);
	}
}
