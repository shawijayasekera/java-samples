package com.javasamples.designpatterns.hfsamples.singletonpattern.threadsafe.doublelock;

public class ChocolateBoilerTestDrive {

	public static void main(String[] args) {
		ChocolateBoiler chocolateBoiler = ChocolateBoiler.getInstance();
		chocolateBoiler.fill();
		chocolateBoiler.boil();
		chocolateBoiler.drain();
	}
}
