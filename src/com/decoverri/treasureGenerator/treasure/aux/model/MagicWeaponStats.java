package com.decoverri.treasureGenerator.treasure.aux.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.Interval;

@Entity
public class MagicWeaponStats {

	@Id
	@GeneratedValue
	private long id;

	private int bonus;
	private int numberOfAbilities;
	private int abilityBonus;

	private int numberOfSecondAbility;
	private int secondAbilityBonus;

	@Enumerated(EnumType.STRING)
	private MagicItemStrength strength;

	@Embedded
	private Interval interval;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getNumberOfAbilities() {
		return numberOfAbilities;
	}

	public void setNumberOfAbilities(int numberOfAbilities) {
		this.numberOfAbilities = numberOfAbilities;
	}

	public int getAbilityBonus() {
		return abilityBonus;
	}

	public void setAbilityBonus(int abilityBonus) {
		this.abilityBonus = abilityBonus;
	}

	public int getNumberOfSecondAbility() {
		return numberOfSecondAbility;
	}

	public void setNumberOfSecondAbility(int numberOfSecondAbility) {
		this.numberOfSecondAbility = numberOfSecondAbility;
	}

	public int getSecondAbilityBonus() {
		return secondAbilityBonus;
	}

	public void setSecondAbilityBonus(int secondAbilityBonus) {
		this.secondAbilityBonus = secondAbilityBonus;
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
		StringBuilder builder = new StringBuilder();
		builder.append("+" + bonus + " enhancement bonus");
		if (abilityBonus > 0) {
			builder.append(" plus " + numberOfAbilities + " +" + abilityBonus + " ability");
		}
		if (secondAbilityBonus > 0) {
			builder.append(" and " + numberOfSecondAbility + " +" + secondAbilityBonus + " ability");
		}
		return builder.toString();
	}

}
