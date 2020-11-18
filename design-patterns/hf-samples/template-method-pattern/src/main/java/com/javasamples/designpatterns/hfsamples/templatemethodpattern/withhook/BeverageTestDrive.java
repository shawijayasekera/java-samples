package com.javasamples.designpatterns.hfsamples.templatemethodpattern.withhook;

public class BeverageTestDrive {

	public static void main(String[] args) {

		CoffeeWithHook coffeeWithHook = new CoffeeWithHook();
		TeaWithHook teaWithHook = new TeaWithHook();
		
		System.out.println("\nMaking coffee...");
		coffeeWithHook.prepareRecipe();
		
		System.out.println("\nMaking tea...");
		teaWithHook.prepareRecipe();
	}
}
