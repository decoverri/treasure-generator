package com.decoverri.treasureGenerator.model;

import javax.persistence.Embeddable;

@Embeddable
public class Dice {

	private int numberOfDice;

	private int numberOfSides;

	public Dice() {
		this.numberOfDice = 1;
		this.numberOfSides = 6;
	}
	
	public Dice(int numberOfSides) {
		this.numberOfDice = 1;
		this.numberOfSides = numberOfSides;
	}

	public Dice(int numberOfSides, int numberOfDice) {
		this.numberOfDice = numberOfDice;
		this.numberOfSides = numberOfSides;
	}

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

	@Override
	public String toString() {
		return numberOfDice + "d" + numberOfSides;
	}

}
