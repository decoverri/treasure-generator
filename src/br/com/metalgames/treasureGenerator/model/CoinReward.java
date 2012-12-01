package br.com.metalgames.treasureGenerator.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CoinReward {

	@Id
	private int value;

	private int cpNumberOfDice;
	private int cpBaseDiceSize;
	private int cpMultiplier;

	private int spNumberOfDice;
	private int spBaseDiceSize;
	private int spMultiplier;

	private int gpNumberOfDice;
	private int gpBaseDiceSize;
	private int gpMultiplier;

	private int ppNumberOfDice;
	private int ppBaseDiceSize;
	private int ppMultiplier;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getCpNumberOfDice() {
		return cpNumberOfDice;
	}

	public void setCpNumberOfDice(int cpNumberOfDice) {
		this.cpNumberOfDice = cpNumberOfDice;
	}

	public int getCpBaseDiceSize() {
		return cpBaseDiceSize;
	}

	public void setCpBaseDiceSize(int cpBaseDiceSize) {
		this.cpBaseDiceSize = cpBaseDiceSize;
	}

	public int getCpMultiplier() {
		return cpMultiplier;
	}

	public void setCpMultiplier(int cpMultiplier) {
		this.cpMultiplier = cpMultiplier;
	}

	public int getSpNumberOfDice() {
		return spNumberOfDice;
	}

	public void setSpNumberOfDice(int spNumberOfDice) {
		this.spNumberOfDice = spNumberOfDice;
	}

	public int getSpBaseDiceSize() {
		return spBaseDiceSize;
	}

	public void setSpBaseDiceSize(int spBaseDiceSize) {
		this.spBaseDiceSize = spBaseDiceSize;
	}

	public int getSpMultiplier() {
		return spMultiplier;
	}

	public void setSpMultiplier(int spMultiplier) {
		this.spMultiplier = spMultiplier;
	}

	public int getGpNumberOfDice() {
		return gpNumberOfDice;
	}

	public void setGpNumberOfDice(int gpNumberOfDice) {
		this.gpNumberOfDice = gpNumberOfDice;
	}

	public int getGpBaseDiceSize() {
		return gpBaseDiceSize;
	}

	public void setGpBaseDiceSize(int gpBaseDiceSize) {
		this.gpBaseDiceSize = gpBaseDiceSize;
	}

	public int getGpMultiplier() {
		return gpMultiplier;
	}

	public void setGpMultiplier(int gpMultiplier) {
		this.gpMultiplier = gpMultiplier;
	}

	public int getPpNumberOfDice() {
		return ppNumberOfDice;
	}

	public void setPpNumberOfDice(int ppNumberOfDice) {
		this.ppNumberOfDice = ppNumberOfDice;
	}

	public int getPpBaseDiceSize() {
		return ppBaseDiceSize;
	}

	public void setPpBaseDiceSize(int ppBaseDiceSize) {
		this.ppBaseDiceSize = ppBaseDiceSize;
	}

	public int getPpMultiplier() {
		return ppMultiplier;
	}

	public void setPpMultiplier(int ppMultiplier) {
		this.ppMultiplier = ppMultiplier;
	}

}
