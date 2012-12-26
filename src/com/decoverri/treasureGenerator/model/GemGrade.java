package com.decoverri.treasureGenerator.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GemGrade {

	@Id
	@GeneratedValue
	private long id;

	@Column(unique = true)
	private int grade;

	private String description;

	@Embedded
	private GemValue value;

	public int getGrade() {
		return grade;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
