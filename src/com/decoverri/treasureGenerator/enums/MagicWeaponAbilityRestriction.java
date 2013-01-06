package com.decoverri.treasureGenerator.enums;

public enum MagicWeaponAbilityRestriction {

	BLUDGEONING,
	PIERCING,
	SLASHING,
	PIERCING_OR_SLASHING,
	BLUDGEONING_AND_PIERCING,
	BOW,
	CROSSBOW,
	COMPOSITE_BOW,
	BOW_AND_CROSSBOW,
	FIREARM,
	ANY;

	public boolean equals(MagicWeaponAbilityRestriction type) {
		
		boolean case1 = (this == type);
		
		boolean case2 = (this == MagicWeaponAbilityRestriction.ANY || type == MagicWeaponAbilityRestriction.ANY);
		
		boolean case3 = (this == MagicWeaponAbilityRestriction.PIERCING && type == MagicWeaponAbilityRestriction.PIERCING_OR_SLASHING)
					 || (this == MagicWeaponAbilityRestriction.PIERCING_OR_SLASHING && type == MagicWeaponAbilityRestriction.PIERCING);
		
		boolean case4 = (this == MagicWeaponAbilityRestriction.SLASHING && type == MagicWeaponAbilityRestriction.PIERCING_OR_SLASHING)
					 || (this == MagicWeaponAbilityRestriction.PIERCING_OR_SLASHING && type == MagicWeaponAbilityRestriction.SLASHING);

		boolean case5 = (this == MagicWeaponAbilityRestriction.BLUDGEONING && type == MagicWeaponAbilityRestriction.BLUDGEONING_AND_PIERCING)
					 || (this == MagicWeaponAbilityRestriction.BLUDGEONING_AND_PIERCING && type == MagicWeaponAbilityRestriction.BLUDGEONING);

		boolean case6 = (this == MagicWeaponAbilityRestriction.PIERCING && type == MagicWeaponAbilityRestriction.BLUDGEONING_AND_PIERCING)
					 || (this == MagicWeaponAbilityRestriction.BLUDGEONING_AND_PIERCING && type == MagicWeaponAbilityRestriction.PIERCING);

		boolean case7 = (this == MagicWeaponAbilityRestriction.BOW && type == MagicWeaponAbilityRestriction.BOW_AND_CROSSBOW)
					 || (this == MagicWeaponAbilityRestriction.BOW_AND_CROSSBOW && type == MagicWeaponAbilityRestriction.BOW);

		boolean case8 = (this == MagicWeaponAbilityRestriction.CROSSBOW && type == MagicWeaponAbilityRestriction.BOW_AND_CROSSBOW)
					 || (this == MagicWeaponAbilityRestriction.BOW_AND_CROSSBOW && type == MagicWeaponAbilityRestriction.CROSSBOW);

		boolean case9 = (this == MagicWeaponAbilityRestriction.COMPOSITE_BOW && type == MagicWeaponAbilityRestriction.BOW_AND_CROSSBOW)
					 || (this == MagicWeaponAbilityRestriction.BOW_AND_CROSSBOW && type == MagicWeaponAbilityRestriction.COMPOSITE_BOW);

		return case1 || case2 || case3 || case4 || case5 || case6 || case7 || case8 || case9;
	}
}
