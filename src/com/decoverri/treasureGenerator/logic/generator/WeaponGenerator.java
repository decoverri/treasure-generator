package com.decoverri.treasureGenerator.logic.generator;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.treasure.WeaponDao;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.treasure.Weapon;

public class WeaponGenerator {

	private WeaponDao weaponDao;

	private DiceRoller roller;
	private Dice d100;

	public WeaponGenerator(Session session) {
		this.weaponDao = new WeaponDao(session);
		this.roller = new DiceRoller();
		this.d100 = new Dice(100);
	}

	public List<Weapon> generate(int quantity) {
		ArrayList<Weapon> weapons = new ArrayList<Weapon>();

		for (int i = 0; i < quantity; i++) {
			weapons.add(generate());
		}

		return weapons;
	}

	public Weapon generate() {
		System.out.println("Generating weapon");

		Weapon weapon = weaponDao.getWeapon(roller.roll(d100));

		System.out.println("Result: " + weapon.getName());

		return weapon;
	}

}
