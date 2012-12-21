package com.decoverri.treasureGenerator.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.decoverri.treasureGenerator.interfaces.Treasure;

public class Gemstone implements Treasure {

	@Id
	@GeneratedValue
	private long id;

	@Column(unique=true)
	private String name;

	@Embedded
	private GemGrade grade;

	@Embedded
	private Interval chanceInterval;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GemGrade getGrade() {
		return grade;
	}

	public void setGrade(GemGrade grade) {
		this.grade = grade;
	}

	public Interval getChanceInterval() {
		return chanceInterval;
	}

	public void setChanceInterval(Interval chanceInterval) {
		this.chanceInterval = chanceInterval;
	}

	@Override
	public String toString() {
		return name;
	}

}
