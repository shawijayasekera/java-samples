package com.javasamples.mvc.jsp.mvcjspservletexample.model;

import java.util.Arrays;
import java.util.List;

public class EmployeeService {

	public List<Employee> getEmployees() {
		return Arrays.asList(new Employee(100, "Shashika", "Wijayasekera"), new Employee(200, "Hiroshani", "Ekanayaka"),
				new Employee(300, "Senaka", "Bandara"));
	}
}
