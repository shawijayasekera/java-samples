package com.javasamples.designpatterns.hfsamples.templatemethodpattern;

public class BeverageTestDrive {

	public static void main(String[] args) {

		Coffee coffee = new Coffee();
		Tea tea = new Tea();
		
		System.out.println("\nMaking coffee...");
		coffee.prepareRecipe();
		
		System.out.println("\nMaking tea...");
		tea.prepareRecipe();
	}
}
