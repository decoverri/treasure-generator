package com.decoverri.treasureGenerator.logic;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.SpecificWeaponDao;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.SpecificWeapon;

public class SpecificWeaponGenerator {

	private Session session;

	public SpecificWeaponGenerator(Session session) {
		this.session = session;
	}

	public SpecificWeapon generate(MagicItemStrength strength) {

		SpecificWeaponDao weaponDao = new SpecificWeaponDao(session);

		Dice d100 = new Dice(100);
		DiceRoller roller = new DiceRoller();

		System.out.println("Generating " + strength + " specific weapon");
		SpecificWeapon weapon = weaponDao.getSpecificWeapon(strength, roller.roll(d100));
		System.out.println("Result: " + weapon.getName() + "\n");

		return weapon;
	}

}
