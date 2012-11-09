package br.com.generator.model;

import br.com.generator.interfaces.DiceGenerated;

public class GemValue implements DiceGenerated {

	Money base;
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
	public double getBonus() {
		return base.getValue();
	}

}
