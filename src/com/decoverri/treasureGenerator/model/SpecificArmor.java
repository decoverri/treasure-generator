package com.decoverri.treasureGenerator.model;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.interfaces.Treasure;

public class SpecificArmor implements Treasure {

	private String name;
	private double price;
	private MagicItemStrength strength;
	private Interval interval;

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

}
