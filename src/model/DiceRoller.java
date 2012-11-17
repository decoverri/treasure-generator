package model;

import interfaces.DiceGenerated;

public class DiceRoller {

	public int roll(DiceGenerated diceRoll) {
		return roll(diceRoll.getBaseValue(), diceRoll.getNumberOfDice(), diceRoll.getBaseDice());
	}

	public int roll(int numberOfDice, Dice die) {
		return roll(0, numberOfDice, die);
	}
	
	public int roll(double baseValue, int numberOfDice, Dice die) {

		int singleRoll;
		int total = 0;

		System.out.println("Rolling " + numberOfDice + die + "...");

		for (int i = 0; i < numberOfDice; i++) {
			singleRoll = die.roll();
			System.out.print( (i == 0 ? "" : ", ") );
			System.out.print(singleRoll);
			total += singleRoll;
		}
		System.out.println("");

		total += baseValue;
		
		return total;
	}
}
