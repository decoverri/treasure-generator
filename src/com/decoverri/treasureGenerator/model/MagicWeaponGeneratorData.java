package com.decoverri.treasureGenerator.model;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;

public class MagicWeaponGeneratorData {

	private int quantity;

	private MagicItemStrength strength;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public MagicItemStrength getStrength() {
		return strength;
	}

	public void setStrength(MagicItemStrength strength) {
		this.strength = strength;
	}

}
