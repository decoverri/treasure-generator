package com.decoverri.treasureGenerator.model;

import javax.persistence.Embeddable;

@Embeddable
public class Interval {

	private int bottomValue;
	private int topValue;

	public boolean contains(int number) {
		return (number >= bottomValue && number <= topValue);
	}

	public int getBottomValue() {
		return bottomValue;
	}

	public void setBottomValue(int minValue) {
		this.bottomValue = minValue;
	}

	public int getTopValue() {
		return topValue;
	}

	public void setTopValue(int maxValue) {
		this.topValue = maxValue;
	}
	
}
