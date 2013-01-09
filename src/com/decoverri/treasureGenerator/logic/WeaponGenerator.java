package com.decoverri.treasureGenerator.logic;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.WeaponDao;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.Weapon;

public class WeaponGenerator {

	private Session session;

	public WeaponGenerator(Session session) {
		this.session = session;
	}

	public Weapon generate() {

		WeaponDao weaponDao = new WeaponDao(session);

		Dice d100 = new Dice(100);
		DiceRoller roller = new DiceRoller();

		System.out.println("Generating weapon");
		Weapon weapon = weaponDao.getWeapon(roller.roll(d100));
		System.out.println("Result: " + weapon.getName());

		return weapon;
	}

}
