package com.test.lambdas.lambdabasic.java8lambdastarter.thisreference;

public class LambdaThisReferenceExample {

	public static void main(String[] args) {

		LambdaThisReferenceExample lambdaThisReferenceExample = new LambdaThisReferenceExample();

		lambdaThisReferenceExample.doProcess(10, i -> {

			System.out.println("Call doProcess method directly from the main method");
			System.out.println("Value of i is : " + i);

			/*
			 * we can't use "this" here. Because we are in a static context
			 */
			// System.out.println(this);
		});

		lambdaThisReferenceExample.execute();
	}

	public void doProcess(int i, Process p) {

		p.process(i);
	}

	public void execute() {

		doProcess(10, i -> {

			System.out.print("\n");
			System.out.println("Call doProcess method through the execute method");
			System.out.println("Value of i is : " + i);

			/*
			 * In this example "this" will refer to the caller of the execute method. Caller
			 * of the execute method is LambdaThisReferenceExample instance. So it will
			 * prints the object reference of the LambdaThisReferenceExample. If
			 * LambdaThisReferenceExample overrides the toString method it calls the
			 * toString method.
			 * 
			 * Lambda will not override the "this" reference. It is same as the outside of
			 * the lambda expression.
			 */
			System.out.println(this);
		});
	}

	@Override
	public String toString() {

		return "This is the main LambdaThisReferenceExample class instance";
	}
}
