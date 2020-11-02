package com.test.lambdas.lambdabasic.java8lambdastarter.greetsample.java8way;

public class Greeter {

	public void greet(Greeting greeting) {

		greeting.perform();
	}

	public static void main(String[] args) {

		/*
		 * Following two are almost same. But the difference is we are implementing the
		 * interface by implementing the function in lambda and helloWorldGreeting we
		 * are creating a class which implements the interface and provide the logic in
		 * concrete class.
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

		System.out.print("\n");

		/*
		 * Following we create a class implementation without class name. So it will
		 * call as anonymous inner class. Lambda is another way to implement this
		 * anonymous inner class. But there are some differences between anonymous inner
		 * class and lambda.
		 */

		Greeting innerSpringGreeting = new Greeting() {

			public void perform() {

				System.out.println("Hello Spring");
			}
		};

		Greeting lambdaSpringGreeting = () -> System.out.println("Hello Spring");

		innerSpringGreeting.perform();
		lambdaSpringGreeting.perform();
	}
}
