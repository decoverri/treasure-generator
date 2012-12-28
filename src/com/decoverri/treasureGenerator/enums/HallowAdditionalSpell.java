package com.decoverri.treasureGenerator.enums;

public enum HallowAdditionalSpell {

	DEATH_WARD("death ward"),
	DIMENSIONAL_ANCHOR("dimensional anchor"),
	DISCERN_LIES("discern lies"),
	FREEDOM_OF_MOVEMENT("freedom of movement");

	private final String name;

	private HallowAdditionalSpell(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
