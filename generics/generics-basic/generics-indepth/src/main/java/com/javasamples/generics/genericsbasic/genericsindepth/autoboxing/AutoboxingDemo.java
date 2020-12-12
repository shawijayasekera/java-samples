package com.javasamples.generics.genericsbasic.genericsindepth.autoboxing;

public class AutoboxingDemo {

	public static void main(String[] args) {

		/*
		 * Following is called as boxing. It will create new instance of Integer type
		 * and assign the value in primitive.
		 */
		int i = 10;
		Integer x = i;

		/*
		 * Following is called as unboxing. It will get the wrapper class instance and
		 * assign the value to the primitive.
		 */
		Integer y = new Integer(20);
		int e = y;
	}
}
