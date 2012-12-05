package com.decoverri.treasureGenerator.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.decoverri.treasureGenerator.enums.Currency;

@Entity
public class CoinGenerator {

	@Id
	@GeneratedValue
	private long id;

	private Dice dice;
	
	private int numberOfDice;
	
	private int multiplier;
	
	@Enumerated(EnumType.STRING)
	private Currency currency;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	public int getNumberOfDice() {
		return numberOfDice;
	}

	public void setNumberOfDice(int numberOfDice) {
		this.numberOfDice = numberOfDice;
	}

	public int getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
