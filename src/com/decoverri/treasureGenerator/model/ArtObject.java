package com.decoverri.treasureGenerator.model;

import com.decoverri.treasureGenerator.interfaces.Treasure;

public class ArtObject implements Treasure {

	private String name;
	private ArtGrade grade;
	private Coins price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArtGrade getGrade() {
		return grade;
	}

	public void setGrade(ArtGrade grade) {
		this.grade = grade;
	}

	public Coins getPrice() {
		return price;
	}

	public void setPrice(Coins price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return name;
	}
}
