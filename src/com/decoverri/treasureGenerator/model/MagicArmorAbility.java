package com.decoverri.treasureGenerator.model;

public class MagicArmorAbility implements MagicArmorAndShieldAbility {

	private String name;
	private int abilityBonus;
	private double price;
	private boolean priceInBonus;
	private Interval interval;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getAbilityBonus() {
		return abilityBonus;
	}

	public void setAbilityBonus(int abilityBonus) {
		this.abilityBonus = abilityBonus;
	}

	@Override
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public boolean isPriceInBonus() {
		return priceInBonus;
	}

	public void setPriceInBonus(boolean priceInBonus) {
		this.priceInBonus = priceInBonus;
	}

	public Interval getInterval() {
		return interval;
	}

	public void setInterval(Interval interval) {
		this.interval = interval;
	}
}
