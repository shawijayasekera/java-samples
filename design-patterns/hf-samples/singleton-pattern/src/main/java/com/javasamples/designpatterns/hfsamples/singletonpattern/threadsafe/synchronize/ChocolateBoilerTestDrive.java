package com.javasamples.designpatterns.hfsamples.singletonpattern.threadsafe.synchronize;

public class ChocolateBoilerTestDrive {

	public static void main(String[] args) {
		ChocolateBoiler chocolateBoiler = ChocolateBoiler.getInstance();
		chocolateBoiler.fill();
		chocolateBoiler.boil();
		chocolateBoiler.drain();
	}
}
