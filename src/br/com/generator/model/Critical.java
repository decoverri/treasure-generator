package br.com.generator.model;

public class Critical {

	private Interval range;
	private int multiplier;

	public Interval getRange() {
		return range;
	}

	public void setRange(Interval criticalRange) {
		this.range = criticalRange;
	}

	public int getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(int criticalMultiplier) {
		this.multiplier = criticalMultiplier;
	}

}
