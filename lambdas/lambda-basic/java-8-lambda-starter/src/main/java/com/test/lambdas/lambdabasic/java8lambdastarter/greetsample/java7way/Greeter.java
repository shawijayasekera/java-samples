package com.test.lambdas.lambdabasic.java8lambdastarter.greetsample.java7way;

/* In java 7 we are writing abstract behaviors in interface and implements it in classes. 
 * After that we are passing that implemented class as behaviors.
 * This is how OOP works 
 * Actually we are passing things (objects) which has behaviors
*/
public class Greeter {

	public void greet(Greeting greeting) {

		greeting.perform();
	}

	public static void main(String[] args) {

		Greeter greeter = new Greeter();

		HelloWorldGreeting helloWorldGreeting = new HelloWorldGreeting();
		greeter.greet(helloWorldGreeting);

		JavaGreeting javaGreeting = new JavaGreeting();
		greeter.greet(javaGreeting);
	}
}
