package com.javasamples.designpatterns.hfsamples.templatemethodpattern;

public class Coffee extends CaffeineBeverage {

	@Override
	public void brew() {

		System.out.println("Dripping coffee through filter");
	}

	@Override
	public void addCondiments() {

		System.out.println("Add sugar and milk");
	}
}
