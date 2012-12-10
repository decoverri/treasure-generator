package com.decoverri.treasureGenerator.model;

import java.util.Random;

public class Dice {

	private static final Random RANDOM = new Random();

	private int numberOfDice;

	private int numberOfSides;

	public int getNumberOfDice() {
		return numberOfDice;
	}

	public void setNumberOfDice(int numberOfDice) {
		this.numberOfDice = numberOfDice;
	}

	public int getNumberOfSides() {
		return numberOfSides;
	}

	public void setNumberOfSides(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}

	public int roll() {
		int singleRoll;
		int result = 0;

		for (int i = 0; i < numberOfDice; i++) {
			singleRoll = RANDOM.nextInt(this.numberOfSides) + 1;
			System.out.print((i == 0 ? "" : ", "));
			System.out.print(singleRoll);
			result += singleRoll;

		}
		System.out.println("");
		System.out.println("Sum: " + result);
		return result;
	}

	@Override
	public String toString() {
		return numberOfDice + "d" + numberOfSides;
	}

}
