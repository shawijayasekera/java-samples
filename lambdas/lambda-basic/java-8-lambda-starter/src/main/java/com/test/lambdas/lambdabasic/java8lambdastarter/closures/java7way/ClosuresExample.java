package com.test.lambdas.lambdabasic.java8lambdastarter.closures.java7way;

public class ClosuresExample {

	public static void main(String[] args) {

		int a = 10;

		/*
		 * Before the java 8 we have to define the b as following. That is for avoid the
		 * value change of b. final int b = 20;
		 */
		int b = 20;

		doProcess(a, new Process() {

			@Override
			public void process(int i) {

				/*
				 * Variable b is not define in the anonymous class. Also it will not execute
				 * inside the anonymous class and it will execute inside the doProcess method.
				 * But it is still work. That is because java compiler trusts that we don't
				 * change the value of b. So it will take the value of b and passes.
				 */

				/*
				 * We don't allow to do following and java compiler says following.
				 * "Local variable b defined in an enclosing scope must be final or effectively final"
				 */
				// b = 40;
				System.out.println(i + b);
			}
		});
	}

	public static void doProcess(int i, Process p) {

		p.process(i);
	}
}
