package com.dp.strategypattern;

import com.dp.strategypattern.behaviors.fly.FlyRocketPowered;

public class MiniDuckSimulator {

	public static void main(String[] args) {

		Duck mallardDuck = new MallardDuck();
		mallardDuck.performQuack();
		mallardDuck.performFly();
		
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
	}
}
