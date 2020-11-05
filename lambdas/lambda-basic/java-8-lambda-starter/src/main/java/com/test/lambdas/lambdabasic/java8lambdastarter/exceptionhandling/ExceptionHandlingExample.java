package com.test.lambdas.lambdabasic.java8lambdastarter.exceptionhandling;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

	public static void main(String[] args) {

		int[] someNumbers = { 1, 2, 3, 4 };
		int key = 2;

		System.out.println("Add key value");
		process(someNumbers, key, (v, k) -> System.out.println(v + k));

		System.out.print("\n");
		System.out.println("Devide by key value");
		process(someNumbers, key, (v, k) -> System.out.println(v / k));

		System.out.print("\n");
		System.out.println("Generate arithmetic exception");

		key = 0;
		// 1st way
		process(someNumbers, key, (v, k) -> {

			try {

				System.out.println(v / k);
			} catch (ArithmeticException e) {

				System.out.println("An arithmetic exception happened");
			}
		});

		System.out.print("\n");
		// 2nd way
		process(someNumbers, key, wrapperLambda((v, k) -> System.out.println(v / k)));
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {

		for (int i : someNumbers) {

			consumer.accept(i, key);
		}
	}

	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {

		return (v, k) -> {

			try {

				consumer.accept(v, k);
			} catch (ArithmeticException e) {

				System.out.println("Exception caught in wrapper lambda");
			}
		};
	}
}
