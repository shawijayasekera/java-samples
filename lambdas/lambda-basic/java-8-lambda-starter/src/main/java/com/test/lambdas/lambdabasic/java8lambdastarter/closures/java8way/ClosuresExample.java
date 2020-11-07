package com.test.lambdas.lambdabasic.java8lambdastarter.closures.java8way;

public class ClosuresExample {

	public static void main(String[] args) {

		int a = 10;

		/*
		 * Before the java 8 we have to define the b as following. That is for avoid the
		 * value change of b. final int b = 20;
		 */
		int b = 20;

		/*
		 * Java compiler get the freeze value of b and passes to the lambda. This is
		 * call as effectively final. Because variable b is not declare as final but
		 * java compiler trusts that we don't change the value of b. Therefore it takes
		 * the value of b and freeze it and passes to the lambda.
		 */
		doProcess(a, i -> System.out.println(i + b));
	}

	public static void doProcess(int i, Process p) {

		p.process(i);
	}
}
