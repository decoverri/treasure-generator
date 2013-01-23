package com.decoverri.treasureGenerator.logic.generator;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.treasure.SpecificWeaponDao;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.treasure.SpecificWeapon;

public class SpecificWeaponGenerator {

	private SpecificWeaponDao weaponDao;

	private DiceRoller roller;
	private Dice d100;

	public SpecificWeaponGenerator(Session session) {
		this.weaponDao = new SpecificWeaponDao(session);
		this.roller = new DiceRoller();
		this.d100 = new Dice(100);
	}

	public SpecificWeapon generate(MagicItemStrength strength) {
		System.out.println("Generating " + strength + " specific weapon");

		SpecificWeapon weapon = weaponDao.getSpecificWeapon(strength, roller.roll(d100));

		System.out.println("Result: " + weapon.getName() + "\n");

		return weapon;
	}

}
