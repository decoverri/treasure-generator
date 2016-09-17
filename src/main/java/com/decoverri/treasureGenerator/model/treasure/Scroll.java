package com.decoverri.treasureGenerator.model.treasure;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.decoverri.treasureGenerator.enums.MagicItemRarity;
import com.decoverri.treasureGenerator.enums.MagicType;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.model.Interval;

@Entity
public class Scroll implements Treasure {

	@Id
	@GeneratedValue
	private long id;

	private String spell;
	private int spellLevel;
	private int casterLevel;
	private double price;

	@Enumerated(EnumType.STRING)
	private MagicItemRarity rarity;

	@Enumerated(EnumType.STRING)
	private MagicType type;

	@Embedded
	private Interval interval;

	@Override
	public double getTreasureValue() {
		return getPrice();
	}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public MagicItemRarity getRarity() {
		return rarity;
	}

	public void setRarity(MagicItemRarity rarity) {
		this.rarity = rarity;
	}

	public MagicType getType() {
		return type;
	}

	public void setType(MagicType type) {
		this.type = type;
	}

	public Interval getInterval() {
		return interval;
	}

	public void setInterval(Interval interval) {
		this.interval = interval;
	}

	public String getName() {
		return "Scroll of " + spell.toLowerCase().substring(0,1) + spell.substring(1) + " (" + type + ", CL: " + casterLevel + ")";
	};
	
	@Override
	public String toString() {
		return "Scroll of " + spell.toLowerCase().substring(0,1) + spell.substring(1) + " (" + type + ", CL: " + casterLevel + ", " + price + "gp)";
	}

	@Override
	public String getTreasureName() {
		return getName();
	}

	
}
