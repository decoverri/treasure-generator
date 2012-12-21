package com.decoverri.treasureGenerator.model;

import javax.persistence.Embeddable;

@Embeddable
public class GemGrade {

	private int grade;
	private String description;
	private GemValue value;

	public int getGrade() {
		return grade;
	}

	public void setGrade(int number) {
		this.grade = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public GemValue getValue() {
		return value;
	}

	public void setValue(GemValue value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Grade " + grade + " gem";
	}
	
}
