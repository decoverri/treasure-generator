package com.decoverri.treasureGenerator.enums;

public enum MagicItemRarity {

	COMMON("common"),
	UNCOMMON("uncommon");

	private final String name;

	private MagicItemRarity(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
