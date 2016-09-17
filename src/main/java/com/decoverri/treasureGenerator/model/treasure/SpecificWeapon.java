package com.decoverri.treasureGenerator.model.treasure;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.model.Interval;

@Entity
public class SpecificWeapon implements Treasure, Cloneable {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	private double price;

	@Enumerated(EnumType.STRING)
	private MagicItemStrength strength;

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

	public Interval getInterval() {
		return interval;
	}

	public void setInterval(Interval interval) {
		this.interval = interval;
	}

	@Override
	public String toString() {
		return this.name + " (price " + this.price + "gp)";
	}
	
	@Override
	public SpecificWeapon clone() {
		SpecificWeapon specificWeapon = new SpecificWeapon();
		specificWeapon.setName(name);
		specificWeapon.setPrice(price);
		specificWeapon.setStrength(strength);
		specificWeapon.setInterval(interval);
		return specificWeapon;
	}

	@Override
	public String getTreasureName() {
		return getName();
	}

}
