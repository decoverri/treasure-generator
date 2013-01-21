package com.decoverri.treasureGenerator.model.treasure.complement;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import com.decoverri.treasureGenerator.enums.MagicWeaponAbilityRestriction;
import com.decoverri.treasureGenerator.enums.WeaponType;
import com.decoverri.treasureGenerator.model.Interval;

@Entity
public class MagicWeaponAbility {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	@Enumerated(EnumType.STRING)
	private WeaponType type;

	@Enumerated(EnumType.STRING)
	private MagicWeaponAbilityRestriction restriction;

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

	public WeaponType getType() {
		return type;
	}

	public void setType(WeaponType type) {
		this.type = type;
	}

	public MagicWeaponAbilityRestriction getRestriction() {
		return restriction;
	}

	public void setRestriction(MagicWeaponAbilityRestriction restriction) {
		this.restriction = restriction;
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

	@Override
	public String toString() {
		return name;
	}

}
