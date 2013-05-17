package com.decoverri.treasureGenerator.enums;

public enum Currency {
	CP("copper pieces"),
	SP("silver pieces"),
	GP("gold pieces"),
	PP("platinum pieces");
	
	private final String name;

	private Currency (String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
