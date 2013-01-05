package com.decoverri.treasureGenerator.enums;

public enum DamageType {

	BLUDGEONING,
	PIERCING,
	SLASHING,
	PIERCING_OR_SLASHING,
	ANY;

	public boolean equals(DamageType type) {
		
		boolean case1 = (this == type);
		
		boolean case2 = (this == DamageType.ANY || type == DamageType.ANY);
		
		boolean case3 = (this == DamageType.PIERCING && type == DamageType.PIERCING_OR_SLASHING)
					 || (this == DamageType.PIERCING_OR_SLASHING && type == DamageType.PIERCING);
		
		boolean case4 = (this == DamageType.SLASHING && type == DamageType.PIERCING_OR_SLASHING)
					 || (this == DamageType.PIERCING_OR_SLASHING && type == DamageType.SLASHING);

		return case1 || case2 || case3 || case4;
	}
}
