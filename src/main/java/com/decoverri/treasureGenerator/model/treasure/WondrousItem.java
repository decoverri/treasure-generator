package com.decoverri.treasureGenerator.model.treasure;

import static com.decoverri.treasureGenerator.enums.BodySlot.SLOTLESS;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.enums.BodySlot;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.model.Interval;

@Entity
public class WondrousItem implements Treasure {

	@Id
	@GeneratedValue
	private long id;

	private String name;
	private double price;

	@Enumerated(EnumType.STRING)
	private MagicItemStrength strength;

	@Enumerated(EnumType.STRING)
	private BodySlot slot;

	@Embedded
	private Interval interval;

	@Override
	public double getTreasureValue() {
		return getPrice();
	}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public MagicItemStrength getStrength() {
		return strength;
	}

	public void setStrength(MagicItemStrength strength) {
		this.strength = strength;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name + " (");

		if (slot != SLOTLESS) {
			builder.append(slot + ", ");
		}

		builder.append("price " + price + "gp)");
		return builder.toString();
	}
}
