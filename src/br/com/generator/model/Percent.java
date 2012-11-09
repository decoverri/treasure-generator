package br.com.generator.model;

public class Percent {

	private double value;

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value + "%";
	}
}
