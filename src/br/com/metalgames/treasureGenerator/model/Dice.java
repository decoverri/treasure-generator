package br.com.metalgames.treasureGenerator.model;
import java.util.Random;

public class Dice {

	private int numberOfSides;

	public Dice(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}

	public int roll() {
		return new Random().nextInt(this.numberOfSides) + 1;
	}

	public int getNumberOfSides() {
		return numberOfSides;
	}

	@Override
	public String toString() {
		return "d" + numberOfSides;
	}
}
