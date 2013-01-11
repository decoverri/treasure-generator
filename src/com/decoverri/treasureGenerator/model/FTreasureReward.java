package com.decoverri.treasureGenerator.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class FTreasureReward {

	@Id
	@GeneratedValue
	private long id;

	private int value;

	@OneToMany
	private List<CoinGeneratorData> coins;

	@OneToMany
	private List<ArmorGeneratorData> nonmagicalArmors;

	@OneToMany
	private List<MagicArmorGeneratorData> armors;

	private int nonmagicalWeapons;

	@OneToMany
	private List<MagicWeaponGeneratorData> weapons;

	@OneToMany
	private List<RingGeneratorData> rings;

	@OneToMany
	private List<WondrousItemGeneratorData> wondrousItems;

	@OneToMany
	private List<PotionGeneratorData> potions;

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

	public List<CoinGeneratorData> getCoins() {
		return coins;
	}

	public void setCoins(List<CoinGeneratorData> coins) {
		this.coins = coins;
	}

	public List<ArmorGeneratorData> getNonmagicalArmors() {
		return nonmagicalArmors;
	}

	public void setNonmagicalArmors(List<ArmorGeneratorData> nonmagicalArmors) {
		this.nonmagicalArmors = nonmagicalArmors;
	}

	public List<MagicArmorGeneratorData> getArmors() {
		return armors;
	}

	public void setArmors(List<MagicArmorGeneratorData> armors) {
		this.armors = armors;
	}

	public int getNonmagicalWeapons() {
		return nonmagicalWeapons;
	}

	public void setNonmagicalWeapons(int nonmagicalWeapons) {
		this.nonmagicalWeapons = nonmagicalWeapons;
	}

	public List<MagicWeaponGeneratorData> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<MagicWeaponGeneratorData> weapons) {
		this.weapons = weapons;
	}

	public List<RingGeneratorData> getRings() {
		return rings;
	}

	public void setRings(List<RingGeneratorData> rings) {
		this.rings = rings;
	}

	public List<WondrousItemGeneratorData> getWondrousItems() {
		return wondrousItems;
	}

	public void setWondrousItems(List<WondrousItemGeneratorData> wondrousItems) {
		this.wondrousItems = wondrousItems;
	}

	public List<PotionGeneratorData> getPotions() {
		return potions;
	}

	public void setPotions(List<PotionGeneratorData> potions) {
		this.potions = potions;
	}

}
