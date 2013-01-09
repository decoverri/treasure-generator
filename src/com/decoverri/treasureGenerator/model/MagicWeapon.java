package com.decoverri.treasureGenerator.model;

import java.util.List;

import com.decoverri.treasureGenerator.enums.Size;
import com.decoverri.treasureGenerator.interfaces.Treasure;

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

		for (MagicWeaponAbility property : this.magicalAbilities) {
			builder.append(property.toString().toLowerCase() + " ");
		}

		Size size = this.baseWeapon.getSize();
		if (size != null && size != Size.MEDIUM) {
			builder.append(size + " ");
		}

		builder.append(this.baseWeapon.getName() + " (price " + calculatePrice() + "gp)");
		return builder.toString().toLowerCase();
	}

	private double calculatePrice() {
		double result = this.baseWeapon.getPrice() + 300.0;
		int bonusForPrice = this.bonus;

		for (MagicWeaponAbility property : this.magicalAbilities) {
			if (property.isPriceInBonus()) {
				bonusForPrice += property.getBonus();
			} else {
				result += property.getPrice();
			}
		}

		result += (bonusForPrice * bonusForPrice * 2000.0);

		return result;
	}

}
