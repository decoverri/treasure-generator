package br.com.generator.model;

import br.com.generator.interfaces.DiceGenerated;

public class DiceRoller {

	public int roll(DiceGenerated diceRoll) {
		return roll(diceRoll.getNumberOfDice(), diceRoll.getBaseDice(), diceRoll.getBonus());
	}

	public int roll(int numberOfDice, Dice die) {
		return roll(numberOfDice, die, 0);
	}
	
	public int roll(int numberOfDice, Dice die, double bonus) {

		int singleRoll;
		int total = 0;

		System.out.println("Rolando " + numberOfDice + die + (bonus == 0 ? "" : " + " + bonus));

		for (int i = 0; i < numberOfDice; i++) {
			singleRoll = die.roll();
			System.out.print( (i == 0 ? "" : ", ") );
			System.out.print(singleRoll);
			total += singleRoll;
		}
		System.out.println("");

		total += bonus;
		
		return total;
	}
}
