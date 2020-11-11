package com.test.collections.collectionsbasic.collectionsstarter.equality;

public class StudentExample {

	public static void main(String[] args) {

		Student student1 = new Student(1, "Foo", "Bar", "Science");
		Student student2 = new Student(1, "Foo", "Bar", "Science");

		/*
		 * Following will compare the memory locations. Since these two are in different
		 * memory locations it will return false
		 */
		System.out.print("student1 and student2 pointing to the same memory location: ");
		System.out.println(student1 == student2);

		/*
		 * If you don't override the equals method in your class it will execute the
		 * Object's class implementation. So it will work same as reference check (==).
		 */
		System.out.print("student1 and student2 are equal: ");
		System.out.println(student1.equals(student2));

		System.out.print("\n");

		System.out.println("student1 hashcode: " + student1.hashCode());
		System.out.println("student2 hashcode: " + student2.hashCode());
	}
}
