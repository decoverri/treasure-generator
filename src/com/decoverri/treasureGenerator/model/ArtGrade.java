package com.decoverri.treasureGenerator.model;

public class ArtGrade {

	private int number;
	private String description;
	private Interval chanceInterval;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Interval getChanceInterval() {
		return chanceInterval;
	}

	public void setChanceInterval(Interval chanceInterval) {
		this.chanceInterval = chanceInterval;
	}

	@Override
	public String toString() {
		return "Grade " + number + " art object";
	}
}
