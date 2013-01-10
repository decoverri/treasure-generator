package com.decoverri.treasureGenerator.enums;

public enum BodySlot {

	BELT("belt"),
	BODY("body"),
	CHEST("chest"),
	EYES("eyes"),
	FEET("feet"),
	HANDS("hands"),
	HEAD("head"),
	HEADBAND("headband"),
	NECK("neck"),
	SHOULDERS("shoulders"),
	WRISTS("wrists"),
	SLOTLESS("slotless");

	private final String name;

	private BodySlot(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
