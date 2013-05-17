package com.decoverri.treasureGenerator.enums;

public enum MagicWeaponAbilityRestriction {

	BLUDGEONING("bludgeoning "),
	PIERCING("piercing "),
	SLASHING("slashing "),
	PIERCING_OR_SLASHING("piercing or slashing "),
	BLUDGEONING_AND_PIERCING("bludgeoning and piercning "),
	BOW("bow "),
	CROSSBOW("crossbow "),
	COMPOSITE_BOW("composite bow "),
	BOW_AND_CROSSBOW("bow or crossbow "),
	THROWN("thrown "),
	FIREARM("firearm "),
	ANY("");

	private final String name;

	private MagicWeaponAbilityRestriction(String name) {
		this.name = name;
	}

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

		boolean case9 = (this == MagicWeaponAbilityRestriction.COMPOSITE_BOW && type == MagicWeaponAbilityRestriction.BOW)
					 || (this == MagicWeaponAbilityRestriction.BOW && type == MagicWeaponAbilityRestriction.COMPOSITE_BOW);

		return case1 || case2 || case3 || case4 || case5 || case6 || case7 || case8 || case9;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
