package com.test.lambdas.lambdabasic.java8lambdastarter.runnablesample.java8way;

/* Instead of creating new type for the lambdas java uses interfaces. 
 * This is because to achieve the backward compatibility. 
 * So we can write lambda to previously released libs if that libs have interfaces with only one method.
 * Runnable interface will be an example for this.
 * If java has introduce new type for the lambdas all libs have release again to supports lambda 
*/
public class RunnableExample {

	public static void main(String[] args) {

		// 1st way
		Thread myLambdaThreadInline = new Thread(() -> System.out.println("Inline printed inside runnable"));
		myLambdaThreadInline.run();

		// 2nd way
		Runnable runnableLambda = () -> System.out.println("Printed inside runnable");
		Thread myLambdaThread = new Thread(runnableLambda);
		myLambdaThread.run();
	}
}
