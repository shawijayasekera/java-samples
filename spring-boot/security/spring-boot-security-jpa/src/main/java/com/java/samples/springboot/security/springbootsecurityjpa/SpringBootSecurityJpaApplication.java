package com.java.samples.springboot.security.springbootsecurityjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.java.samples.springboot.security.springbootsecurityjpa.models.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class) // when class path scan this will tell where are the repository classes
public class SpringBootSecurityJpaApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootSecurityJpaApplication.class, args);
	}
}
