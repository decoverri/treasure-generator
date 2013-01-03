package com.decoverri.treasureGenerator.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import com.decoverri.treasureGenerator.enums.ArmorType;

@Entity
public class MagicArmorAbility {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	@Enumerated(EnumType.STRING)
	private ArmorType type;

	private int bonus;
	private double price;

	@Type(type = "true_false")
	private boolean priceInBonus;

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

	public ArmorType getType() {
		return type;
	}

	public void setType(ArmorType type) {
		this.type = type;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isPriceInBonus() {
		return priceInBonus;
	}

	public void setPriceInBonus(boolean priceInBonus) {
		this.priceInBonus = priceInBonus;
	}

	public Interval getInterval() {
		return interval;
	}

	public void setInterval(Interval interval) {
		this.interval = interval;
	}
}
