package com.test.springboot.springdatamongodb.accessingdatamongodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.test.springboot.springdatamongodb.accessingdatamongodb.dao.CustomerRepository;
import com.test.springboot.springdatamongodb.accessingdatamongodb.dto.domain.Customer;

@SpringBootApplication
public class AccessingDataMongoDbApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	private Logger logger = LoggerFactory.getLogger(AccessingDataMongoDbApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(AccessingDataMongoDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		customerRepository.deleteAll();

		// save a couple of customers
		customerRepository.save(new Customer("Alice", "Smith"));
		customerRepository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		logger.info("Customers found with findAll():");
		logger.info("-------------------------------");
		for (Customer customer : customerRepository.findAll()) {

			logger.info("" + customer);
		}
		logger.info("\n");

		// fetch an individual customer
		logger.info("Customer found with findByFirstName('Alice'):");
		logger.info("--------------------------------");
		logger.info("" + customerRepository.findByFirstName("Alice"));

		logger.info("Customers found with findByLastName('Smith'):");
		logger.info("--------------------------------");
		for (Customer customer : customerRepository.findByLastName("Smith")) {

			logger.info("" + customer);
		}
	}
}
