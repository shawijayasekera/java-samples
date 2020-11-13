package com.test.collections.collectionsbasic.collectionsstarter.map;

import java.util.HashMap;
import java.util.Map;

import com.test.collections.collectionsbasic.collectionsstarter.comparator.Employee;

public class HashMapExample {

	public static void main(String[] args) {

		Map<Integer, Employee> employeeMap = new HashMap<>();

		Employee employee1 = new Employee(2, "Foo", "Bar", "HR");
		Employee employee2 = new Employee(1, "Bar", "Baz", "IT");
		Employee employee3 = new Employee(3, "Blash", "Bar", "Finacne");

		employeeMap.put(employee1.getId(), employee1);
		employeeMap.put(employee2.getId(), employee2);
		employeeMap.put(employee3.getId(), employee3);

		System.out.println("All elements in the hash map: " + employeeMap);

		System.out.print("\n");

		/*
		 * Retrieve value using key.
		 */
		System.out.println("Retrieve the value in key 1: " + employeeMap.get(1));

		System.out.print("\n");

		/*
		 * Insert null value to the map.
		 */
		employeeMap.put(200, null);
		employeeMap.put(201, null);
		System.out.println("All elements in the hash map after insert null value: " + employeeMap);

		System.out.print("\n");

		/*
		 * Retrieve value using key which doesn't exist in the map.
		 */
		System.out.println("Retrieve value using key 300 which doesn't exist in the map: " + employeeMap.get(300));

		System.out.print("\n");

		/*
		 * Iterate over the keys in the map.
		 */
		System.out.println("Iterate over the keys in the map: ");
		for (Integer key : employeeMap.keySet()) {

			System.out.println(key);
		}

		System.out.print("\n");

		/*
		 * Iterate over the values in the map.
		 */
		System.out.println("Iterate over the values in the map: ");
		for (Employee employee : employeeMap.values()) {

			System.out.println(employee);
		}

		System.out.print("\n");

		/*
		 * Iterate over both keys and values in the map.
		 */
		System.out.println("Iterate over both keys and values in the map: ");
		for (Map.Entry<Integer, Employee> entry : employeeMap.entrySet()) {

			System.out.println(entry.getKey() + " --> " + entry.getValue());
		}

		System.out.print("\n");

		/*
		 * Retrieve value using key 100 and if that key is not exist assign a default
		 * value. But this will not save that key and value to the map.
		 */
		System.out.println("Retrieve value using key 100 and if that is not exist assign a default value: "
				+ employeeMap.getOrDefault(100, new Employee(100, "Test 1", "Test 1", "Test Dept 1")));

		System.out.print("\n");

		/*
		 * Assign a value to the key if that key doesn't have a value.
		 */
		System.out.println("Retrieve the value in key 201 before assign a value: " + employeeMap.get(201));
		employeeMap.putIfAbsent(201, new Employee(201, "Test 2", "Test 2", "Test Dept 2"));
		System.out
				.println("After assign a value to the key 201 because it dosen't have a value before: " + employeeMap);

		System.out.print("\n");

		/*
		 * Iterate over the map using for each only.
		 */
		System.out.println("Iterate over the map using for each only: ");
		employeeMap.forEach((key, value) -> System.out.println(value));

		System.out.print("\n");

		/*
		 * Assign a value to the key if that key doesn't exist.
		 */
		System.out.println("Retrieve the value in key 225 before assign a value: " + employeeMap.get(201));
		employeeMap.computeIfAbsent(225, key -> new Employee(225, "Test 3", "Test 3", "Test Dept 3"));
		System.out.println("After assign a value to the key 225 and that key doesn't exist before: " + employeeMap);

		System.out.print("\n");
	}
}
