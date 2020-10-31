package com.test.springboot.springdatamongodb.accessingdatamongodb.dao;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.test.springboot.springdatamongodb.accessingdatamongodb.dto.domain.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	public Customer findByFirstName(String firstName);
	public List<Customer> findByLastName(String lastName);
}
