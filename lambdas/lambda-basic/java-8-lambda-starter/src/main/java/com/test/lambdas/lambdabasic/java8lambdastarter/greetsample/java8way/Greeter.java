package com.test.lambdas.lambdabasic.java8lambdastarter.greetsample.java8way;

public class Greeter {

	public void greet(Greeting greeting) {

		greeting.perform();
	}

	public static void main(String[] args) {

		/* Following two are almost same.
		 * But the difference is we are implementing the interface by implementing the function in lambda 
		 * and helloWorldGreeting we are creating a class which implements the interface and provide the logic in concrete class. 
		*/
		Greeting helloWorldGreeting = new HelloWorldGreeting();
		Greeting lambdaHelloWorldGreeting = () -> System.out.println("Hello World");
		
		helloWorldGreeting.perform();
		lambdaHelloWorldGreeting.perform();
		
		System.out.print("\n");
		
		Greeting javaGreeting = new JavaGreeting();
		Greeting lambdaJavaGreeting = () -> System.out.println("Hello Java");
	
		javaGreeting.perform();
		lambdaJavaGreeting.perform();
	}
}
