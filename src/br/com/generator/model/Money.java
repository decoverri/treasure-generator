package br.com.generator.model;

public class Money {

	//Default: gold pieces
	private double value;

	public double getValue() {
		return value;
	}

	public double getValueInCopperPieces() {
		return value * 100;
	}

	public double getValueInSilverPieces() {
		return value * 10;
	}

	public double getValueInPlatinumPieces() {
		return value / 10;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
