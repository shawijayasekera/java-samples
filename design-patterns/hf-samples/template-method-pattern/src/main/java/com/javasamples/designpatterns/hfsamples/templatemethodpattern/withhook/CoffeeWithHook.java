package com.javasamples.designpatterns.hfsamples.templatemethodpattern.withhook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHook extends CaffeineBeverageWithHook {

	@Override
	public void brew() {

		System.out.println("Dripping coffee through filter");
	}

	@Override
	public void addCondiments() {

		System.out.println("Add sugar and milk");
	}

	/*
	 * Override the hook method. So we can add condiments based on the user input.
	 */
	@Override
	public boolean customerWantsCondiments() {

		String answer = getUserInput();

		if (answer.toLowerCase().startsWith("y")) {

			return true;
		} else {

			return false;
		}
	}

	private String getUserInput() {

		String answer = null;

		System.out.println("Would you like milk and sugar with your coffee (y/n)? ");

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {

			answer = in.readLine();
		} catch (IOException ioe) {

			System.err.println("IO error trying to read your answer");
		}

		if (answer == null) {

			return "no";
		}

		return answer;
	}
}
