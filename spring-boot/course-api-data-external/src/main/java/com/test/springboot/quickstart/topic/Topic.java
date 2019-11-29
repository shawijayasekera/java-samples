package com.test.springboot.quickstart.topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.test.springboot.quickstart.validation.GEZero;
import com.test.springboot.quickstart.validation.MSISDN;

@Entity
public class Topic {

	@Id
	@NotBlank
	private String id;

	@NotBlank
	@MSISDN
	private String name;

	@NotBlank
	private String description;

	@NotNull
	@GEZero
	private Double price;

	public Topic() {
		super();
	}

	public Topic(@NotBlank String id, @NotBlank @MSISDN String name, @NotBlank String description,
			@NotNull @GEZero Double price) {
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
