package com.decoverri.treasureGenerator.model;

import java.util.List;

import com.decoverri.treasureGenerator.enums.Size;
import com.decoverri.treasureGenerator.interfaces.Treasure;

public class MagicArmor implements Treasure {

	private Armor baseArmor;
	private int bonus;
	private List<MagicArmorAndShieldAbility> magicalProperties;

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

	public List<MagicArmorAndShieldAbility> getMagicalProperties() {
		return magicalProperties;
	}

	public void setMagicalProperties(
			List<MagicArmorAndShieldAbility> magicalProperties) {
		this.magicalProperties = magicalProperties;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("+" + this.bonus + " ");

		for (MagicArmorAndShieldAbility property : this.magicalProperties) {
			builder.append(property.toString().toLowerCase() + " ");
		}

		Size size = this.baseArmor.getSize();
		if (size != null && size != Size.MEDIUM) {
			builder.append(size + " ");
		}

		builder.append(this.baseArmor.getNome() + " (price " + calculatePrice() + "gp)");
		return builder.toString().toLowerCase();
	}

	private double calculatePrice() {
		double result = this.baseArmor.getPrice() + 150.0;
		int bonusForPrice = this.bonus;

		for (MagicArmorAndShieldAbility property : this.magicalProperties) {
			if (property.isPriceInBonus()) {
				bonusForPrice += property.getAbilityBonus();
			} else {
				result += property.getPrice();
			}
		}

		result += (bonusForPrice * bonusForPrice * 1000.0);
		
		return result;
	}

}
