package com.dp.strategypattern;

import com.dp.strategypattern.behaviors.fly.FlyWithWings;
import com.dp.strategypattern.behaviors.quack.Quack;

public class MallardDuck extends Duck {

	public MallardDuck() {

		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	@Override
	public void display() {

		System.out.println("I am a real mallard duck");
	}
}
