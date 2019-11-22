package com.dp.strategypattern;

import com.dp.strategypattern.behaviors.fly.FlyNoWay;
import com.dp.strategypattern.behaviors.quack.Quack;

public class ModelDuck extends Duck {

	public ModelDuck() {

		quackBehavior = new Quack();
		flyBehavior = new FlyNoWay();
	}

	@Override
	public void display() {

		System.out.println("I am a model duck");
	}
}
