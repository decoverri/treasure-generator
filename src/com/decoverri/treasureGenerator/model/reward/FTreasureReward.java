package com.decoverri.treasureGenerator.model.reward;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.decoverri.treasureGenerator.interfaces.TreasureReward;
import com.decoverri.treasureGenerator.model.data.ArmorGeneratorData;
import com.decoverri.treasureGenerator.model.data.CoinGeneratorData;
import com.decoverri.treasureGenerator.model.data.MagicArmorGeneratorData;
import com.decoverri.treasureGenerator.model.data.MagicWeaponGeneratorData;
import com.decoverri.treasureGenerator.model.data.PotionGeneratorData;
import com.decoverri.treasureGenerator.model.data.RingGeneratorData;
import com.decoverri.treasureGenerator.model.data.WondrousItemGeneratorData;

@Entity
public class FTreasureReward implements TreasureReward {

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

	@Override
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
