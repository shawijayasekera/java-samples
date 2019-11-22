package com.dp.strategypattern.behaviors.quack;

import com.dp.strategypattern.behaviors.QuackBehavior;

public class Squeak implements QuackBehavior{

	@Override
	public void quack() {

		System.out.println("Squeak");
	}
}
