package com.decoverri.treasureGenerator.model.treasure;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.model.GemGrade;
import com.decoverri.treasureGenerator.model.Interval;

@Entity
public class Gemstone implements Treasure {

	@Id
	@GeneratedValue
	private long id;

	@Column(unique = true)
	private String name;

	@ManyToOne
	private GemGrade grade;

	@Embedded
	private Interval chanceInterval;

	@Transient
	private double value;

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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return name + " (worth " + value + "gp)";
	}

}
