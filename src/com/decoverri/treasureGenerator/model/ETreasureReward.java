package com.decoverri.treasureGenerator.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ETreasureReward {

	@Id
	@GeneratedValue
	private long id;

	private int value;

	@OneToMany
	private List<ArmorGeneratorData> nonmagicalArmors;

	private int nonmagicalWeapons;

	@OneToMany
	private List<MagicArmorGeneratorData> armors;

	@OneToMany
	private List<MagicWeaponGeneratorData> weapons;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<ArmorGeneratorData> getNonmagicalArmors() {
		return nonmagicalArmors;
	}

	public void setNonmagicalArmors(List<ArmorGeneratorData> nonmagicalArmors) {
		this.nonmagicalArmors = nonmagicalArmors;
	}

	public int getNonmagicalWeapons() {
		return nonmagicalWeapons;
	}

	public void setNonmagicalWeapons(int nonmagicalWeapons) {
		this.nonmagicalWeapons = nonmagicalWeapons;
	}

	public List<MagicArmorGeneratorData> getArmors() {
		return armors;
	}

	public void setArmors(List<MagicArmorGeneratorData> armors) {
		this.armors = armors;
	}

	public List<MagicWeaponGeneratorData> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<MagicWeaponGeneratorData> weapons) {
		this.weapons = weapons;
	}

}
