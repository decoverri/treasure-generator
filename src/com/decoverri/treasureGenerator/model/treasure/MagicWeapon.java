package com.decoverri.treasureGenerator.model.treasure;

import java.util.List;

import com.decoverri.treasureGenerator.enums.Size;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.model.MagicWeaponAbility;

public class MagicWeapon implements Treasure {

	private Weapon baseWeapon;
	private int bonus;
	private List<MagicWeaponAbility> magicalAbilities;

	public Weapon getBaseWeapon() {
		return baseWeapon;
	}

	public void setBaseWeapon(Weapon baseWeapon) {
		this.baseWeapon = baseWeapon;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public List<MagicWeaponAbility> getMagicalAbilities() {
		return magicalAbilities;
	}

	public void setMagicalAbilities(List<MagicWeaponAbility> magicalAbilities) {
		this.magicalAbilities = magicalAbilities;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("+" + this.bonus + " ");

		for (MagicWeaponAbility ability : this.magicalAbilities) {
			builder.append(ability.toString().toLowerCase() + " ");
		}

		Size size = this.baseWeapon.getSize();
		if (size != null && size != Size.MEDIUM) {
			builder.append(size + " ");
		}

		if (this.baseWeapon.getInterval().getBottomValue() > 92) {
			for (MagicWeaponAbility ability : this.magicalAbilities) {
				builder.append(ability.getRestriction());
			}
		}
		
		builder.append(this.baseWeapon.getName() + " (" + calculatePrice() + "gp)");
		return builder.toString().toLowerCase();
	}

	private double calculatePrice() {
		double result = this.baseWeapon.getPrice() + 300.0;
		int bonusForPrice = this.bonus;

		for (MagicWeaponAbility ability : this.magicalAbilities) {
			if (ability.isPriceInBonus()) {
				bonusForPrice += ability.getBonus();
			} else {
				result += ability.getPrice();
			}
		}

		result += (bonusForPrice * bonusForPrice * 2000.0);

		return result;
	}

}
