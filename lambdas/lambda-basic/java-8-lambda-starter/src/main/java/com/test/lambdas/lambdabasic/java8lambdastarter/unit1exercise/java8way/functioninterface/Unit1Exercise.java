package com.test.lambdas.lambdabasic.java8lambdastarter.unit1exercise.java8way.functioninterface;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Unit1Exercise {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60), 
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), 
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);

		// Step 1: Sort list by last name
		Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		// Step 2: Create a method that prints all elements in the list
		System.out.println("Printing all people");
		
		// Using separate printAll method to print all people
		printAll(people);
		
		/*
		 * Using same printConditionally method to print all people. In this we are
		 * always returning true. So all people will print
		 */
		System.out.print("\n");
		printConditionally(people, p -> true);
		
		/* In this we are using performConditionally method witch takes another lambda. 
		 * With we can change what should print dynamically 
		 * 1st argument : object list
		 * 2nd argument : condition that should perform
		 * 3rd argument : what should perform according to the condition
		 */
		System.out.print("\n");
		performConditionally(people, p -> true, p -> System.out.println(p));

		// Step 3: Create a method that prints all people that have name beginning with C
		System.out.print("\n");
		System.out.println("Printing all people that have last name beginning with C");
		printConditionally(people, p -> p.getLastName().startsWith("C"));
		
		/* In this we are using performConditionally method witch takes another lambda. 
		 * With we can change what should print dynamically 
		 * 1st argument : object list
		 * 2nd argument : condition that should perform
		 * 3rd argument : what should perform according to the condition
		 */
		System.out.print("\n");
		performConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p.getLastName()));
		
		// Step 3: Create a method that prints all people that have name beginning with C
		System.out.print("\n");
		System.out.println("Printing all people that have first name beginning with C");
		printConditionally(people, p -> p.getFirstName().startsWith("C"));
		
		/* In this we are using performConditionally method witch takes another lambda. 
		 * With we can change what should print dynamically 
		 * 1st argument : object list
		 * 2nd argument : condition that should perform
		 * 3rd argument : what should perform according to the condition
		 */
		System.out.print("\n");
		performConditionally(people, p -> p.getFirstName().startsWith("C"), p -> System.out.println(p.getFirstName()));
	}

	private static void printAll(List<Person> people) {

		for (Person person : people) {

			System.out.println(person);
		}
	}
	
	private static void printConditionally(List<Person> people, Predicate<Person> predicate) {

		for (Person person : people) {
			
			if (predicate.test(person)) {
				
				System.out.println(person);
			}
		}
	}
	
	private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {

		for (Person person : people) {
			
			if (predicate.test(person)) {
				
				consumer.accept(person);
			}
		}
	}
}