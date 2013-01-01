package com.decoverri.treasureGenerator.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;

@Entity
public class WandGeneratorData {

	@Id
	@GeneratedValue
	private long id;

	private int quantity;

	@Enumerated(EnumType.STRING)
	private MagicItemStrength strength;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
