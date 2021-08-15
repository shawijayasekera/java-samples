package com.javasamples.designpatterns.hfsamples.singletonpattern.classic;

public class ChocolateBoiler {

	public static ChocolateBoiler uniqueChocolateBoiler;
	
	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}
	
	public static ChocolateBoiler getInstance() {
		if(uniqueChocolateBoiler == null) {
			uniqueChocolateBoiler = new ChocolateBoiler();
		}
		return uniqueChocolateBoiler;
	}
	
	private boolean empty;
	private boolean boiled;
	
	public void fill() {
		if(isEmpty()) {
			empty = false;
			boiled = false;
			// fill the boiler with a milk/chocolate mixture 
			System.out.println("Executing fill method");
		}
	}
	
	public void drain() {
		if(!isEmpty() && isBoiled()) {
			// drain the boiled milk and chocolate
			System.out.println("Executing drain method");
			empty = true;
		}
	}
	
	public void boil() {
		if(!isEmpty() && !isBoiled()) {
			// bring the contents to a boil
			System.out.println("Executing boil method");
			boiled = true;
		}
	}
	
	public boolean isEmpty() {
		return empty;
	}
	
	public boolean isBoiled() {
		return boiled;
	}
}
