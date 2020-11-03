package com.test.lambdas.lambdabasic.java8lambdastarter.functionalinterface;

/* When we declare an interface for lambda we have to define only one abstract method.
 * Using @FunctionalInterface annotation we can mark the interface to have only one abstract method. 
 * Therefore if someone tries to add another abstract method to the interface compiler will show an error.
 * This annotation is an optional one. Java compiler doesn't require it for lambda types.
 * But it is good practice to add it.
*/
@FunctionalInterface
public interface Greeting {

	void perform();
}
