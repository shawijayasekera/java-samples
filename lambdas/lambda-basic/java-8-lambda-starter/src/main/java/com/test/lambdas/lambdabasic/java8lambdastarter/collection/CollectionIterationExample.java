package com.test.lambdas.lambdabasic.java8lambdastarter.collection;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class CollectionIterationExample {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60), 
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), 
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));

		/*
		 * Following two are external iterators. Because we are controlling the iteration
		 * and telling the runtime what we need to do.
		 * 
		 * In for loop we are maintaining the index and we tell how to increase the
		 * index.
		 * 
		 * In fore each loop still we are getting the people collection, create a variable
		 * called person using Person type and access the People collection using that.
		 * 
		 * Also these loops are sequential.
		 */
		
		System.out.println("Using for loop");
		for (int i = 0; i < people.size(); i++) {

			System.out.println(people.get(i));
		}
		
		System.out.print("\n");

		System.out.println("Using for each loop");
		for (Person person : people) {

			System.out.println(person);
		}
		
		/*
		 * Java 8 introduce internal iterators. In that iterators we only say what we
		 * need to iterate. How the iterate happens is up to the runtime and we are not
		 * controlling that.
		 * 
		 * We only tell runtime to iterate over the people collection and what we expect
		 * after every iteration. We don't tell how to iterate or control the iteration.
		 * 
		 * This lambda fore each loop takes the lambda expression which is Consumer
		 * type.
		 * 
		 * Advantage of using this is because it is easy to processor to handle in
		 * multiple processors. This is not sequential and run time can decide like, 1st
		 * 3 elements will execute in 1st core and other 2 elements will execute in 2nd
		 * core.
		 */
		System.out.print("\n");
		System.out.println("Using lambda for each loop");
		// 1st way
		people.forEach(p -> System.out.println(p));
		
		System.out.print("\n");
		// 2nd way
		Consumer consumer = p -> System.out.println(p);
		people.forEach(consumer);
		
		System.out.print("\n");
		// 3rd way
		people.forEach(System.out::println);
		
		
	}
}
