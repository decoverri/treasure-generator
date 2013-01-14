package com.decoverri.treasureGenerator.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MetamagicRod {

	@Id
	@GeneratedValue
	private long id;

	private String type;
	private int spellLevelIncrement;

	@Embedded
	private Interval interval;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSpellLevelIncrement() {
		return spellLevelIncrement;
	}

	public void setSpellLevelIncrement(int spellLevelIncrement) {
		this.spellLevelIncrement = spellLevelIncrement;
	}

	public Interval getInterval() {
		return interval;
	}

	public void setInterval(Interval interval) {
		this.interval = interval;
	}

	@Override
	public String toString() {
		return type;
	}
}
