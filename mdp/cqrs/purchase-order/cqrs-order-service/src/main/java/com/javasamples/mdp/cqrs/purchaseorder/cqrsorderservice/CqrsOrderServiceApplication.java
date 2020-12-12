package com.javasamples.mdp.cqrs.purchaseorder.cqrsorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CqrsOrderServiceApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(CqrsOrderServiceApplication.class, args);
	}
}
