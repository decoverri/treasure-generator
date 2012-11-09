package br.com.generator.model;

public class Weight {

	private double value;

	//Default: pounds
	public double getValue() {
		return value;
	}

	public double getValueInKilograms() {
		return value * 0.4535924;
	}

	public void setValue(double vaule) {
		this.value = vaule;
	}

}
