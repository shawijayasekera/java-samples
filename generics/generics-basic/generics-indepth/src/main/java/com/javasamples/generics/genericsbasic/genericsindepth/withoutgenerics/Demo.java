package com.javasamples.generics.genericsbasic.genericsindepth.withoutgenerics;

import java.util.ArrayList;
import java.util.Date;

public class Demo {

	public static void main(String[] args) {

		ArrayList names = new ArrayList();

		names.add(new Date());
		names.add("Name 1");
		names.add("Name 2");

		/*
		 * Here you are going to case Date type to the String type and you will get
		 * ClassCastException.
		 */
		String myFriendName = (String) names.get(0);
		System.out.println(myFriendName);
	}
}
