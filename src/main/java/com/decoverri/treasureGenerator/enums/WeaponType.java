package com.decoverri.treasureGenerator.enums;

public enum WeaponType {

	MELEE("melee"),
	RANGED("ranged");

	private final String name;

	private WeaponType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
