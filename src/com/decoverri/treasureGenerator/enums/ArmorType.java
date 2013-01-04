package com.decoverri.treasureGenerator.enums;

public enum ArmorType {

	ARMOR("armor"),
	SHIELD("shield");

	private final String name;

	private ArmorType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
