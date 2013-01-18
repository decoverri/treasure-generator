package com.decoverri.treasureGenerator.treasure.aux.model;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import com.decoverri.treasureGenerator.interfaces.DiceGenerated;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.treasure.model.Coins;

@Embeddable
public class GemValue implements DiceGenerated {

	@Embedded
	private Coins base;

	@Embedded
	private Dice dice;

	private int multiplier;

	@Override
	public Dice getDice() {
		return dice;
	}

	@Override
	public double getBaseValue() {
		return base.getAmount();
	}

	public int getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}

}
