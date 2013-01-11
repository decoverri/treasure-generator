package com.decoverri.treasureGenerator.enums;

public enum MagicItemStrength {

	LEAST_MINOR("least minor"),
	LESSER_MINOR("lesser minor"),
	GREATER_MINOR("greater minor"),
	LESSER_MEDIUM("lesser medium"),
	GREATER_MEDIUM("greater medium"),
	LESSER_MAJOR("lesser major"),
	GREATER_MAJOR("greater major");

	private final String name;

	private MagicItemStrength (String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
