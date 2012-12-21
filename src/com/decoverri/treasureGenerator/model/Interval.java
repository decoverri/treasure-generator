package com.decoverri.treasureGenerator.model;

import javax.persistence.Embeddable;

@Embeddable
public class Interval {

	private int minValue;
	private int maxValue;

	public boolean contains(int number) {
		return (number >= minValue && number <= maxValue);
	}

	public int getMinValue() {
		return minValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
	
}
