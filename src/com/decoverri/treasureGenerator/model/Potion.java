package com.decoverri.treasureGenerator.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.decoverri.treasureGenerator.enums.MagicItemRarity;

@Entity
public class Potion {

	@Id
	@GeneratedValue
	private long id;

	private String spell;
	private int spellLevel;
	private int casterLevel;
	private double preco;

	@Enumerated(EnumType.STRING)
	private MagicItemRarity rarity;

	@Embedded
	private Interval interval;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSpell() {
		return spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	public int getSpellLevel() {
		return spellLevel;
	}

	public void setSpellLevel(int spellLevel) {
		this.spellLevel = spellLevel;
	}

	public int getCasterLevel() {
		return casterLevel;
	}

	public void setCasterLevel(int casterLevel) {
		this.casterLevel = casterLevel;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public MagicItemRarity getRarity() {
		return rarity;
	}

	public void setRarity(MagicItemRarity rarity) {
		this.rarity = rarity;
	}

	public Interval getInterval() {
		return interval;
	}

	public void setInterval(Interval interval) {
		this.interval = interval;
	}

}
