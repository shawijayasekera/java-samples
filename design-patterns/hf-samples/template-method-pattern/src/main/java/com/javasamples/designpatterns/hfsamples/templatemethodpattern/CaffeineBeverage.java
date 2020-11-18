package com.javasamples.designpatterns.hfsamples.templatemethodpattern;

/* Class which has the template method declared as abstract class. 
 * Because it has concrete implementation parts of the algorithm and 
 * some algorithm parts are changing according to the subclass. 
 */
public abstract class CaffeineBeverage {

	public final void prepareRecipe() {

		boilWater();
		brew();
		pourInCoup();
		addCondiments();

	}

	/*
	 * This method has concrete implementation. Because this will not changing
	 * according to the subclass.
	 */
	public void boilWater() {

		System.out.println("Boiling water");
	}

	/*
	 * This method has concrete implementation. Because this will not changing
	 * according to the subclass.
	 */
	public void pourInCoup() {

		System.out.println("Pouring into cup");
	}

	/*
	 * This method declared as abstract because this part of the algorithm need to
	 * be change according to the subclass.
	 */
	public abstract void brew();

	/*
	 * This method declared as abstract because this part of the algorithm need to
	 * be change according to the subclass.
	 */
	public abstract void addCondiments();
}
