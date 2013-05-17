package com.decoverri.treasureGenerator.enums;

public enum MagicType {

	ARCANE("arcane"),
	DIVINE("divine");

	private final String name;

	private MagicType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
