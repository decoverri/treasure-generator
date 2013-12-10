package com.decoverri.treasureGenerator.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;

@Entity
public class TreasureType {

	@Id
	@GeneratedValue
	private long id;

	private char letter;
	private String name;
	private String description;
	
	@ManyToMany
	@OrderBy("value")
	private List<TreasureTypeValue> values;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
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

	public List<TreasureTypeValue> getValues() {
		return values;
	}

	public void setValues(List<TreasureTypeValue> values) {
		this.values = values;
	}

}
