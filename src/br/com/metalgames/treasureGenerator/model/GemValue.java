package br.com.metalgames.treasureGenerator.model;

import br.com.metalgames.treasureGenerator.interfaces.DiceGenerated;

public class GemValue implements DiceGenerated {

	Coins base;
	int numberOfDice;
	Dice die;

	@Override
	public Dice getBaseDice() {
		return die;
	}

	@Override
	public int getNumberOfDice() {
		return numberOfDice;
	}

	@Override
	public double getBaseValue() {
		return base.getAmount();
	}

}
