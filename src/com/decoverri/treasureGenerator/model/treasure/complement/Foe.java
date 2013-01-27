package com.decoverri.treasureGenerator.model.treasure.complement;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.decoverri.treasureGenerator.model.Interval;

@Entity
public class Foe {

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@Embedded
	private Interval interval;

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

	public Interval getInterval() {
		return interval;
	}

	public void setInterval(Interval interval) {
		this.interval = interval;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
