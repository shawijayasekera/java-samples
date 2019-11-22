package com.dp.strategypattern.behaviors.fly;

import com.dp.strategypattern.behaviors.FlyBehavior;

public class FlyNoWay implements FlyBehavior{

	@Override
	public void fly() {
		
		System.out.println("I can not fly");
	}
}
