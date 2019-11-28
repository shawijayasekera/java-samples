package com.test.springboot.quickstart.topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.test.springboot.quickstart.validation.MSISDN;

@Entity
public class Topic {

	@Id
	@NotBlank(message = "id")
	private String id;

	@NotBlank(message = "name")
	@MSISDN
	private String name;

	@NotBlank(message = "description")
	private String description;

	@NotNull(message = "price")
	@DecimalMin(value = "1.00", message = "price")
	private Double price;

	public Topic() {
		super();
	}

	public Topic(@NotBlank(message = "id") String id, @NotBlank(message = "name") String name,
			@NotBlank(message = "description") String description,
			@NotBlank(message = "price") @DecimalMin(value = "1.00", message = "price") Double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
