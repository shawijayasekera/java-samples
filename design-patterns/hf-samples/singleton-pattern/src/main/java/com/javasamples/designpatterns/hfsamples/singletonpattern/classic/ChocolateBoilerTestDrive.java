package com.javasamples.designpatterns.hfsamples.singletonpattern.classic;

public class ChocolateBoilerTestDrive {

	public static void main(String[] args) {
		ChocolateBoiler chocolateBoiler = ChocolateBoiler.getInstance();
		chocolateBoiler.fill();
		chocolateBoiler.boil();
		chocolateBoiler.drain();
	}
}
