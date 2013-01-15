package com.decoverri.treasureGenerator.model.treasure;

import java.util.List;

import com.decoverri.treasureGenerator.enums.Size;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.model.MagicArmorAbility;

public class MagicArmor implements Treasure {

	private Armor baseArmor;
	private int bonus;
	private List<MagicArmorAbility> magicalAbilities;

	public Armor getBaseArmor() {
		return baseArmor;
	}

	public void setBaseArmor(Armor baseArmor) {
		this.baseArmor = baseArmor;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public List<MagicArmorAbility> getMagicalAbilities() {
		return magicalAbilities;
	}

	public void setMagicalAbilities(List<MagicArmorAbility> magicalAbilities) {
		this.magicalAbilities = magicalAbilities;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("+" + this.bonus + " ");

		for (MagicArmorAbility property : this.magicalAbilities) {
			builder.append(property.toString().toLowerCase() + " ");
		}

		Size size = this.baseArmor.getSize();
		if (size != null && size != Size.MEDIUM) {
			builder.append(size + " ");
		}

		builder.append(this.baseArmor.getName() + " (" + calculatePrice() + "gp)");
		return builder.toString().toLowerCase();
	}

	private double calculatePrice() {
		double result = this.baseArmor.getPrice() + 150.0;
		int bonusForPrice = this.bonus;

		for (MagicArmorAbility property : this.magicalAbilities) {
			if (property.isPriceInBonus()) {
				bonusForPrice += property.getBonus();
			} else {
				result += property.getPrice();
			}
		}

		result += (bonusForPrice * bonusForPrice * 1000.0);

		return result;
	}

}
