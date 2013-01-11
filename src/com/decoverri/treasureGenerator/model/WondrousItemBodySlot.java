package com.decoverri.treasureGenerator.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.decoverri.treasureGenerator.enums.BodySlot;

@Entity
public class WondrousItemBodySlot {

	@Id
	@GeneratedValue
	private long id;

	@Enumerated(EnumType.STRING)
	private BodySlot slot;

	@Embedded
	private Interval interval;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BodySlot getSlot() {
		return slot;
	}

	public void setSlot(BodySlot slot) {
		this.slot = slot;
	}

	public Interval getInterval() {
		return interval;
	}

	public void setInterval(Interval interval) {
		this.interval = interval;
	}

}
