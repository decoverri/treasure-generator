package br.com.generator.model;

import br.com.generator.enums.DamageType;
import br.com.generator.interfaces.Damage;

public class WeaponDamage implements Damage {

	private Dice baseDice;
	private int numberOfDice;
	private DamageType type;

	@Override
	public Dice getBaseDice() {
		return baseDice;
	}

	public void setBaseDice(Dice baseDice) {
		this.baseDice = baseDice;
	}

	@Override
	public int getNumberOfDice() {
		return numberOfDice;
	}

	public void setNumberOfDice(int numberOfDice) {
		this.numberOfDice = numberOfDice;
	}

	@Override
	public DamageType getType() {
		return type;
	}

	public void setType(DamageType type) {
		this.type = type;
	}

	@Override
	public double getBonus() {
		return 0;
	}

}
