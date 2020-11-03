package com.test.lambdas.lambdabasic.java8lambdastarter.typeinterface;

public class TypeInterfaceExample {

	public static void main(String[] args) {

		/*
		 * when we write lambda like following de don't declare the types. Java compiler
		 * uses the interface and identify the type of parameter and the return type
		 */
		printLambda(s -> s.length());
	}

	public static void printLambda(StringLengthLambda stringLengthLambda) {

		System.out.println(stringLengthLambda.getLength("Hello Lambda"));
	}
}
