package com.decoverri.treasureGenerator.enums;

public enum ArmorType {

	ARMOR("armor"),
	LIGHT_ARMOR("light armor"),
	MEDIUM_ARMOR("medium armor"),
	HEAVY_ARMOR("heavy armor"),
	SHIELD("shield"),
	LIGHT_ARMOR_OR_SHIELD("light armor or shield");

	private final String name;

	private ArmorType(String name) {
		this.name = name;
	}

	public boolean equals(ArmorType type) {

		boolean case1 = (this == type);

		boolean case2 = (this == ArmorType.LIGHT_ARMOR && type == ArmorType.LIGHT_ARMOR_OR_SHIELD)
				 	 || (this == ArmorType.LIGHT_ARMOR_OR_SHIELD && type == ArmorType.LIGHT_ARMOR);

		boolean case3 = (this == ArmorType.SHIELD && type == ArmorType.LIGHT_ARMOR_OR_SHIELD)
					 || (this == ArmorType.LIGHT_ARMOR_OR_SHIELD && type == ArmorType.SHIELD);

		return case1 || case2 || case3;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
