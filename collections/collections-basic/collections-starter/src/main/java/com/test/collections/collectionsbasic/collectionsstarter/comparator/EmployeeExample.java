package com.test.collections.collectionsbasic.collectionsstarter.comparator;

import java.util.ArrayList;

public class EmployeeExample {

	public static void main(String[] args) {

		Employee employee1 = new Employee(1, "Foo", "Bar", "HR");
		Employee employee2 = new Employee(2, "Bar", "Foo", "IT");
		Employee employee3 = new Employee(3, "Blash", "Bar", "Finacne");

		ArrayList<Employee> employeeList = new ArrayList<>();
		employeeList.add(employee3);
		employeeList.add(employee1);
		employeeList.add(employee2);

		employeeList.sort(null);
		
		System.out.println("Sorted by using comparable with student id: " + employeeList);
		
		System.out.print("\n");
		
		employeeList.sort(new EmployeeLastNameComparator());
		System.out.println("Sorted by using comparator with student last name: " + employeeList);
	}
}
