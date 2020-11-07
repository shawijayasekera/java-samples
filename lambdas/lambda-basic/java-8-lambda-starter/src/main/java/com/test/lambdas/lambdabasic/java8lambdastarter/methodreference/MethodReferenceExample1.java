package com.test.lambdas.lambdabasic.java8lambdastarter.methodreference;

public class MethodReferenceExample1 {

	public static void main(String[] args) {

		/*
		 * Following two implementations are same. 2nd one call as method reference
		 * 
		 * When you have an expression which takes no input arguments and it is call
		 * method without no arguments, we can replace that with method reference.
		 * 
		 * Just think this as alternate syntax.
		 */

		Thread t1 = new Thread(() -> printMessage());
		t1.start();

		Thread t2 = new Thread(MethodReferenceExample1::printMessage);
		t2.start();
	}

	public static void printMessage() {

		System.out.println("Hello");
	}
}
