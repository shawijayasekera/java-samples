package com.test.collections.collectionsbasic.collectionsstarter.equality;

public class EmployeeExample {

	public static void main(String[] args) {

		Employee employee1 = new Employee(1, "Foo", "Bar", "HR");
		Employee employee2 = new Employee(1, "Foo", "Bar", "HR");

		/*
		 * Following will compare the memory locations. Since these two are in different
		 * memory locations it will return false
		 */
		System.out.print("employee1 and employee2 pointing to the same memory location: ");
		System.out.println(employee1 == employee2);

		/*
		 * If you don't override the equals method in your class it will execute the
		 * Object's class implementation. So it will work same as reference check (==).
		 */
		System.out.print("employee1 and employee2 are equal: ");
		System.out.println(employee1.equals(employee2));

		System.out.print("\n");

		System.out.println("employee1 hashcode: " + employee1.hashCode());
		System.out.println("employee2 hashcode: " + employee2.hashCode());
	}
}
