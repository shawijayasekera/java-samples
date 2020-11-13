package com.test.collections.collectionsbasic.collectionsstarter.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		
		Set<String> names = new HashSet<>();
		
		names.add("Name A");
		names.add("Name C");
		names.add("Name B");
		
		/*
		 * Set doesn't maintains the insert order.
		 */
		System.out.println("Not in insert order: " + names);

		System.out.print("\n");
		
		/*
		 * Set doesn't allows duplicates.
		 */
		boolean result = names.add("Name A");
		System.out.println("After adding the duplicate value: " + names);
		System.out.println("After adding the duplicate value, does it change the set: " + result);

		System.out.print("\n");
		
		/*
		 * Remove previous inserted value by giving value. 
		 */
		names.remove("Name A");
		System.out.println("Remove inserted value by giving the value: " + names);

		System.out.print("\n");
		
		/*
		 * Add removed value to the set again.
		 */
		names.add("Name A");
		System.out.println("Add removed value to the set again: " + names);

		System.out.print("\n");
		
		/*
		 * Search on set.
		 */
		boolean isFound = names.contains("Name B");
		System.out.println("Search for the 'Name B' on set and found it: " + isFound);

		System.out.print("\n");
	}
}
