package com.java.samples.springboot.faulttolerance.resilience.moviecatalogservice.models;

public class CatalogItem {

	private String name;

	public CatalogItem() {
		super();
	}

	private String desc;
	private Integer ratings;

	public CatalogItem(String name, String desc, Integer ratings) {
		super();
		this.name = name;
		this.desc = desc;
		this.ratings = ratings;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getRatings() {
		return ratings;
	}

	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}
}
