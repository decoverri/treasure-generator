package com.decoverri.treasureGenerator.logic;

import java.util.Random;

import com.decoverri.treasureGenerator.model.Dice;

public class DiceRoller {

	private static final Random RANDOM = new Random();

	public int roll(Dice dice) {
		System.out.println("Rolling " + dice.getNumberOfDice() + "d" + dice.getNumberOfSides());
		int singleRoll;
		int result = 0;

		for (int i = 0; i < dice.getNumberOfDice(); i++) {
			singleRoll = RANDOM.nextInt(dice.getNumberOfSides()) + 1;
			System.out.print((i == 0 ? "" : ", "));
			System.out.print(singleRoll);
			result += singleRoll;

		}
		System.out.println("");
		if (dice.getNumberOfDice() > 1) {
			System.out.println("Sum: " + result);
		}
		return result;

	}

}
