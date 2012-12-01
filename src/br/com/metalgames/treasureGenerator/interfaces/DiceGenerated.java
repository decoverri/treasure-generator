package br.com.metalgames.treasureGenerator.interfaces;

import br.com.metalgames.treasureGenerator.model.Dice;

public interface DiceGenerated {

	public Dice getBaseDice();

	public int getNumberOfDice();

	public double getBaseValue();

}
