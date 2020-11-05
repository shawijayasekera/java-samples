package com.test.lambdas.lambdabasic.java8lambdastarter.unit1exercise.java8way.functioninterface;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/* In this example we are not using previously used Condition interface. 
 * Because java 8 already provided interface match to the Condition. 
 * Therefore we don't need to write same interface like that.
 * We are using interface called Predicate. 
 * Like the Condition interface it has only one abstract method, which takes the object type and returns the boolean value 
 */
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

		// Step 3: Create a method that prints all people that have name beginning with C
		System.out.print("\n");
		System.out.println("Printing all people that have last name beginning with C");
		printConditionally(people, p -> p.getLastName().startsWith("C"));
		
		// Step 3: Create a method that prints all people that have name beginning with C
		System.out.print("\n");
		System.out.println("Printing all people that have first name beginning with C");
		printConditionally(people, p -> p.getFirstName().startsWith("C"));
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
}