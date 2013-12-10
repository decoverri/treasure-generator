package com.decoverri.treasureGenerator.model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class TreasureType {

	private char letter;
	private String name;
	private String description;
	private List<Integer> values;

	public char getLetter() {
		return letter;
	}

	public void setLetter(char typeLetter) {
		this.letter = typeLetter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public List<Integer> getValues() {
		return values;
	}

	public void setValues(List<Integer> values) {
		this.values = values;
	}
}
