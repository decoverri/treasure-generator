package com.decoverri.treasureGenerator.model.reward;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.decoverri.treasureGenerator.interfaces.TreasureReward;
import com.decoverri.treasureGenerator.model.data.CoinGeneratorData;
import com.decoverri.treasureGenerator.model.data.PotionGeneratorData;
import com.decoverri.treasureGenerator.model.data.ScrollGeneratorData;
import com.decoverri.treasureGenerator.model.data.WandGeneratorData;

@Entity
public class DTreasureReward implements TreasureReward {

	@Id
	@GeneratedValue
	private long id;

	private int value;

	@OneToMany
	private List<CoinGeneratorData> coins;

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
