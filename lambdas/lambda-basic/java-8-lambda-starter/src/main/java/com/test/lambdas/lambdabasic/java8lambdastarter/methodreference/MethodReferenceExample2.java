package com.test.lambdas.lambdabasic.java8lambdastarter.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import com.test.lambdas.lambdabasic.java8lambdastarter.unit1exercise.java8way.functioninterface.Person;

public class MethodReferenceExample2 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60), 
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), 
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));

		/*
		 * Following two implementations are also same. When you have one input argument
		 * and you are calling the method using same argument you can use method
		 * reference.
		 * 
		 * However println method is not a static method and it is instance method. Therefore we have to take the
		 * instance part (System.out) first and then call the println method using ::
		 */
		performConditionally(people, p -> true, p -> System.out.println(p));
		
		System.out.print("\n");
		
		performConditionally(people, p -> true, System.out::println);
	}

	private static void performConditionally(List<Person> people, Predicate<Person> predicate,
			Consumer<Person> consumer) {

		for (Person person : people) {

			if (predicate.test(person)) {

				consumer.accept(person);
			}
		}
	}
}
