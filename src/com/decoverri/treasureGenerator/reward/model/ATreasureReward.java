package com.decoverri.treasureGenerator.reward.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.decoverri.treasureGenerator.data.model.CoinGeneratorData;

@Entity
public class ATreasureReward {

	@Id
	@GeneratedValue
	private long id;

	@Column(unique = true)
	private int value;

	@OneToMany
	private List<CoinGeneratorData> coins;

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

}
