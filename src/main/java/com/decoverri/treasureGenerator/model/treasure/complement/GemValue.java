package com.decoverri.treasureGenerator.model.treasure.complement;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.treasure.Coins;

@Embeddable
public class GemValue {

	@Embedded
	private Coins base;

	@Embedded
	private Dice dice;

	private int multiplier;

	public Dice getDice() {
		return dice;
	}

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
