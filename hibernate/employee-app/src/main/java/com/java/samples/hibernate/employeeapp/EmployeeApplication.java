package com.java.samples.hibernate.employeeapp;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.java.samples.hibernate.employeeapp.entity.Employee;
import com.java.samples.hibernate.employeeapp.entity.Phone;

public class EmployeeApplication {

	public static SessionFactory sessionFactory;
	public static StandardServiceRegistry standardRegistry;
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		try {

			standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			sessionFactory = metaData.getSessionFactoryBuilder().build();
		} catch (Throwable e) {

			System.out.println("Failed to create session factory object: " + e);
			throw new ExceptionInInitializerError(e);
		}

		EmployeeApplication employeeApplication = new EmployeeApplication();
		String more = "yes";
		Integer empID = 0;

		/* Add few employee records in database */
		/*while (more.charAt(0) == 'y' || more.charAt(0) == 'Y') {

			empID = employeeApplication.addEmployee();
			System.out.println("More employees? (y/n)");
			more = in.nextLine();
		}*/

		/* Update employee's records */
		employeeApplication.updateEmployee(15, 380000);

		/* Delete an employee from the database */
		// HE.deleteEmployee(67);

		/* List all employees */
		employeeApplication.listEmployees();

		StandardServiceRegistryBuilder.destroy(standardRegistry);
	}

	/* Method to CREATE an employee in the database */
	public Integer addEmployee() {

		System.out.println("Enter first name: ");
		String fname = in.nextLine();
		System.out.println("Enter last name: ");
		String lname = in.nextLine();
		System.out.println("Enter cell: ");
		String cell = in.nextLine();
		System.out.println("Enter home phone: ");
		String hPhone = in.nextLine();
		System.out.println("Enter salary: ");
		int salary = in.nextInt();
		in.nextLine();

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer employeeID = null;

		try {

			tx = session.beginTransaction();
			Employee employee = new Employee(fname, lname, salary);
			employee.addPhone(new Phone(cell));
			employee.addPhone(new Phone(hPhone));

			employeeID = (Integer) session.save(employee);
			tx.commit();
		} catch (HibernateException e) {

			if (tx != null) {

				tx.rollback();
			}
			e.printStackTrace();
		} finally {

			session.close();
		}

		return employeeID;
	}

	/* Method to list all the employees */
	public void listEmployees() {

		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();

			List<?> employees = session.createQuery("FROM Employee").list();
			employees.stream().forEach(e -> {

				Employee employee = (Employee) e;
				System.out.println("First Name: " + employee.getFirstName());
				System.out.println("Last Name: " + employee.getLastName());
				System.out.println("Salary: " + employee.getSalary());
				Set<?> phoneNums = employee.getPhones();

				phoneNums.stream().forEach(p -> {

					Phone phoneNum = (Phone) p;
					System.out.println("Phone: " + phoneNum.getPhoneNumber());
				});
			});

			tx.commit();
		} catch (HibernateException e) {

			if (tx != null) {

				tx.rollback();
			}

			e.printStackTrace();
		} finally {

			session.close();
		}
	}

	/* Method to UPDATE salary for an employee */
	public void updateEmployee(int employeeId, int salary) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, employeeId);
			employee.setSalary(salary);
			session.update(employee);
			tx.commit();
		} catch (HibernateException e) {

			if (tx != null) {
				
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			
			session.close();
		}
	}
}
