package com.decoverri.treasureGenerator.logic.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.dao.treasure.SpecificWeaponDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.FoeDao;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.treasure.SpecificWeapon;
import com.decoverri.treasureGenerator.model.treasure.complement.Foe;

@Component
public class SpecificWeaponGenerator {

	@Autowired
	private SpecificWeaponDao weaponDao;
	@Autowired
	private FoeDao foeDao;

	private DiceRoller roller;
	private Dice d100;

	public SpecificWeaponGenerator() {
		this.roller = new DiceRoller();
		this.d100 = new Dice(100);
	}

	public SpecificWeapon generate(MagicItemStrength strength) {
		System.out.println("Generating " + strength + " specific weapon");
		SpecificWeapon weapon = weaponDao.getSpecificWeapon(strength, roller.roll(d100));
		System.out.println("Result: " + weapon.getName());

		if (weapon.getName().equals("Slaying arrow")) {
			weapon = setSlayingArrowFoe(weapon);
		}

		System.out.println("");
		return weapon;
	}

	private SpecificWeapon setSlayingArrowFoe(SpecificWeapon weapon) {
		System.out.println("Generating slaying arrow foe");
		Foe foe = foeDao.getFoe(roller.roll(d100));
		System.out.println("Result: " + foe);
		SpecificWeapon arrow = weapon.clone();
		arrow.setName(foe + " " + arrow.getName().toLowerCase());
		return arrow;
	}

}
