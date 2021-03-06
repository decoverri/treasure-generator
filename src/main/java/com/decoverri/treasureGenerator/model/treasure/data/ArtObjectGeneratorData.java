package com.decoverri.treasureGenerator.model.treasure.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.decoverri.treasureGenerator.interfaces.GeneratorData;

@Entity
public class ArtObjectGeneratorData implements GeneratorData {

	@Id
	@GeneratedValue
	private long id;
	
	private int quantity;
	private int grade;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}
