package com.decoverri.treasureGenerator.model.treasure;

import java.util.List;

import com.decoverri.treasureGenerator.enums.Size;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicArmorAbility;

public class MagicArmor implements Treasure {

	private Armor baseArmor;
	private int bonus;
	private List<MagicArmorAbility> magicalAbilities;

	@Override
	public double getTreasureValue() {
		return calculatePrice();
	}

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
	public String getName() {
		StringBuilder builder = new StringBuilder();

		builder.append("+" + this.bonus + " ");

		for (MagicArmorAbility property : this.magicalAbilities) {
			builder.append(property.toString().toLowerCase() + " ");
		}

		Size size = this.baseArmor.getSize();
		if (size != null && size != Size.MEDIUM) {
			builder.append(size + " ");
		}

		builder.append(this.baseArmor.getName());
		return builder.toString().toLowerCase();
	}

	@Override
	public String toString() {
		return getName() + " (" + calculatePrice() + "gp)";
	}

	private double calculatePrice() {
		double result = this.baseArmor.getMasterworkPrice();
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
