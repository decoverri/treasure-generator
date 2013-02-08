package com.decoverri.treasureGenerator.enums;

public enum TreasureType {

	TREASURE_TYPE_A("TreasureTypeA"),
	TREASURE_TYPE_B("TreasureTypeB"),
	TREASURE_TYPE_C("TreasureTypeC"),
	TREASURE_TYPE_D("TreasureTypeD"),
	TREASURE_TYPE_E("TreasureTypeE"),
	TREASURE_TYPE_F("TreasureTypeF"),
	TREASURE_TYPE_G("TreasureTypeG"),
	TREASURE_TYPE_H("TreasureTypeH"),
	TREASURE_TYPE_I("TreasureTypeI");

	private final String name;

	private TreasureType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
