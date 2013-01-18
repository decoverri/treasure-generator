package com.decoverri.treasureGenerator.reward.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.decoverri.treasureGenerator.data.model.CoinGeneratorData;
import com.decoverri.treasureGenerator.data.model.MagicWeaponGeneratorData;
import com.decoverri.treasureGenerator.data.model.PotionGeneratorData;
import com.decoverri.treasureGenerator.data.model.RingGeneratorData;
import com.decoverri.treasureGenerator.data.model.RodGeneratorData;
import com.decoverri.treasureGenerator.data.model.ScrollGeneratorData;
import com.decoverri.treasureGenerator.data.model.StaffGeneratorData;
import com.decoverri.treasureGenerator.data.model.WandGeneratorData;
import com.decoverri.treasureGenerator.data.model.WondrousItemGeneratorData;

@Entity
public class GTreasureReward {

	@Id
	@GeneratedValue
	private long id;

	private int value;

	@OneToMany
	private List<CoinGeneratorData> coins;

	private int nonmagicalWeapons;

	@OneToMany
	private List<MagicWeaponGeneratorData> weapons;

	@OneToMany
	private List<RingGeneratorData> rings;

	@OneToMany
	private List<StaffGeneratorData> staves;

	@OneToMany
	private List<RodGeneratorData> rods;

	@OneToMany
	private List<WondrousItemGeneratorData> wondrousItems;

	@OneToMany
	private List<PotionGeneratorData> potions;

	@OneToMany
	private List<ScrollGeneratorData> scrolls;

	@OneToMany
	private List<WandGeneratorData> wands;

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

	public List<StaffGeneratorData> getStaves() {
		return staves;
	}

	public void setStaves(List<StaffGeneratorData> staves) {
		this.staves = staves;
	}

	public List<RodGeneratorData> getRods() {
		return rods;
	}

	public void setRods(List<RodGeneratorData> rods) {
		this.rods = rods;
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

	public List<ScrollGeneratorData> getScrolls() {
		return scrolls;
	}

	public void setScrolls(List<ScrollGeneratorData> scrolls) {
		this.scrolls = scrolls;
	}

	public List<WandGeneratorData> getWands() {
		return wands;
	}

	public void setWands(List<WandGeneratorData> wands) {
		this.wands = wands;
	}

}