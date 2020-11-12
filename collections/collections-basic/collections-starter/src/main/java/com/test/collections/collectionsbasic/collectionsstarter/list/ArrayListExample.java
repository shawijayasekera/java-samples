package com.test.collections.collectionsbasic.collectionsstarter.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {

		List<String> names = new ArrayList<>();

		names.add("Name A");
		names.add("Name B");

		/*
		 * List maintains the insert order.
		 */
		System.out.println("According to the insert order: " + names);

		System.out.print("\n");
		
		/*
		 * List allows duplicates.
		 */
		names.add("Name A");
		System.out.println("After adding the duplicate value: " + names);

		System.out.print("\n");
		
		/*
		 * We can change the previous value using index based access.
		 */
		names.set(2, "Name C");
		System.out.println("After changeing the value of index 2: " + names);

		System.out.print("\n");
		
		/*
		 * Add new value to the previous inserted index. This will shift the previous
		 * values to the right from the given index.
		 */
		names.add(1, "Name D");
		System.out.println("Add new value to the index 1: " + names);

		System.out.print("\n");
		
		/*
		 * Remove previous inserted value using index based access. This will shift the
		 * remaining values to the left from the given index.
		 */
		names.remove(1);
		System.out.println("Remove inserted value in the index 1: " + names);

		System.out.print("\n");
		
		/*
		 * Remove previous inserted value by giving value.
		 */
		names.remove("Name A");
		System.out.println("Remove inserted value by giving the value: " + names);

		System.out.print("\n");
		
		/*
		 * Add removed value to the same previous index.
		 */
		names.add(0, "Name A");
		System.out.println("Add removed value to the same previous index: " + names);

		System.out.print("\n");
		
		/*
		 * Add duplicate values again.
		 */
		names.add("Name A");
		names.add("Name A");
		names.add("Name A");
		System.out.println("After adding duplicate values again: " + names);

		System.out.print("\n");
		
		/*
		 * Remove previous inserted value by giving value. If there are duplicate values
		 * it will remove the first occurrence only.
		 */
		names.remove("Name A");
		System.out.println("Remove inserted value by giving the value: " + names);

		System.out.print("\n");
		
		/*
		 * Retrieve value using index based access.
		 */
		System.out.println("Retrieve value in 0 index: " + names.get(0));

		System.out.print("\n");
		
		/*
		 * Retrieve value using wrong index. This will throw the
		 * IndexOutOfBoundsException.
		 */
		System.out.print("Retrieve value in 200 index: ");
		System.out.println(names.get(200));
	}
}
