package br.com.generator.model;

public class Distance {

	private double value;

	// Default: feet
	public double getValue() {
		return value;
	}

	public double getValueInMeters() {
		return value * 3.0 / 10.0;
	}

	public double getValueInSquares() {
		return value / 5.0;
	}

	public void setValue(double distance) {
		this.value = distance;
	}
}
