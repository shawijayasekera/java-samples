package com.javasamples.generics.genericsbasic.genericsindepth.withgenerics;

import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<String>();

		/*
		 * Since we define the type, compiler will not allow us to add different types.
		 */
		// names.add(new Date());
		names.add("Name 1");
		names.add("Name 2");

		/*
		 * You don't need to do the casting. Because compiler knows what is the type.
		 */
		// String myFriendName = (String) names.get(0);

		String myFriendName = (String) names.get(0);
		System.out.println(myFriendName);
	}
}
