package com.test.lambdas.lambdabasic.java8lambdastarter.thisreference;

public class AnonymousInnerClassThisReferenceExample {

	public static void main(String[] args) {

		AnonymousInnerClassThisReferenceExample anonymousInnerClassThisReferenceExample = new AnonymousInnerClassThisReferenceExample();

		anonymousInnerClassThisReferenceExample.doProcess(10, new Process() {

			@Override
			public void process(int i) {

				System.out.println("Value of i is : " + i);

				/*
				 * Since we are using anonymous inner class "this" will refer the instance of the
				 * anonymous inner class.
				 */
				System.out.println(this);
			}

			public String toString() {

				return "This is the anonymous inner class";
			}
		});
	}

	public void doProcess(int i, Process p) {

		p.process(i);
	}
}
