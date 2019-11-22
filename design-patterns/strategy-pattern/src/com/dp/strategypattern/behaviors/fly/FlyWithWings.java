package com.dp.strategypattern.behaviors.fly;

import com.dp.strategypattern.behaviors.FlyBehavior;

public class FlyWithWings implements FlyBehavior{

	@Override
	public void fly() {
		
		System.out.println("I am flying with wings");
	}
}
