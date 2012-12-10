package com.decoverri.treasureGenerator.model;

import com.decoverri.treasureGenerator.interfaces.DiceGenerated;

public class GemValue implements DiceGenerated {

	private Coins base;
	private Dice dice;

	@Override
	public Dice getDice() {
		return dice;
	}
	@Override
	public double getBaseValue() {
		return base.getAmount();
	}

}
